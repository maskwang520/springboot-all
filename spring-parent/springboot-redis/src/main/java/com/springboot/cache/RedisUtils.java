package com.springboot.cache;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {

	protected static Logger logger = Logger.getLogger(RedisUtils.class);
	// Redis服务器IP
	private static final String ADDR_ARRAY = "127.0.0.1";
	// private static final String ADDR_ARRAY = "192.168.0.13";
	// Redis的端口号
	private static final int PORT = Integer.parseInt("6379");
	// 访问密码
	// private static final String AUTH ;
	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static final int MAX_ACTIVE = 8;
	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static final int MAX_IDLE = 5;
	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static final int MAX_WAIT = 100000;
	// 超时时间
	private static final int TIMEOUT = 100000;
	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static final boolean TEST_ON_BORROW = true;
	/**
	 * redis过期时间,以秒为单位
	 */
	public final static int EXRP_HOUR = 60 * 60; // 一小时
	public final static int EXRP_DAY = 60 * 60 * 24; // 一天
	public final static int EXRP_MONTH = 60 * 60 * 24 * 30; // 一个月
	private static JedisPool jedisPool = null;
	/**
	 * 初始化Redis连接池
	 */
	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxIdle(MAX_IDLE);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, ADDR_ARRAY.split(",")[0], PORT, TIMEOUT);
			System.out.println("first create jdeispool");
		} catch (Exception e) {
			logger.error("First create JedisPool error : " + e);
		}
	}

	/**
	 * 同步获取Jedis实例
	 * 
	 * @return Jedis
	 */
	public synchronized static Jedis getJedis() {
		try {
			if (jedisPool != null) {
				Jedis jedis = jedisPool.getResource();
				return jedis;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("Get jedis error : " + e);
		}
		return null;
	}

	/**
	 * 释放jedis资源
	 * 
	 * @param jedis
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null && jedisPool != null) {
			jedisPool.returnResource(jedis);
		}
	}

	/**
	 * 设置 String
	 * 
	 * @param key
	 * @param value
	 */
	public static void set(String key, String value) {
		Jedis jedis = null;
		try {
			value = null == value ? "" : value;
			jedis = getJedis();
			jedis.set(key, value);
		} catch (Exception e) {
			logger.error("Set key error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * 获取String值
	 * 
	 * @param key
	 * @return value
	 */
	public static String get(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			if (jedis == null || !jedis.exists(key)) {
				return null;
			}
			return jedis.get(key);
		} catch (Exception e) {
			logger.error("get keyex error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	/**
	 * 设置 过期时间
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 *            以秒为单位 Redis Setex 命令为指定的 key 设置值及其过期时间。如果 key 已经存在， SETEX
	 *            命令将会替换旧的值。
	 */
	public static void set(String key, String value, int seconds) {
		Jedis jedis = null;
		try {
			value = null == value ? "" : value;
			jedis = getJedis();
			jedis.setex(key, seconds, value);
		} catch (Exception e) {
			logger.error("Set keyex error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * 判断redis中是否存在这个K
	 * 
	 * @param key
	 * @return
	 */
	public static Boolean exists(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.exists(key);
		} catch (Exception e) {
			jedisPool.close();
			e.printStackTrace();
			return false;
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * Redis Hmset 命令用于同时将多个 field-value (字段-值)对设置到哈希表中。 此命令会覆盖哈希表中已存在的字段。
	 * 如果哈希表不存在，会创建一个空哈希表，并执行 HMSET 操作
	 * 
	 * @param seconds
	 *            过期时间 Redis Expire命令用于设置键的到期时间。在到指定的到期时间后，在Redis中这个键将失效，不能再使用
	 */
	public static void hmset(String key, Map<String, String> map, int seconds) {
		Jedis jedis = null;
		try {
			if (!map.isEmpty() && !key.isEmpty()) {
				jedis = getJedis();
				jedis.hmset(key, map);
				jedis.expire(key, seconds);
			}
		} catch (Exception e) {
			logger.error("Set keyex error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
	}

	public static void hmset(String key, Map<String, String> map) {
		Jedis jedis = null;
		try {
			if (!map.isEmpty() && !key.isEmpty()) {
				jedis = getJedis();
				jedis.hmset(key, map);
			}
		} catch (Exception e) {
			logger.error("Set keyex error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * String
	 * 
	 * @param key
	 * @param field
	 * @param value
	 *            Redis Hincrby 命令用于为哈希表中的字段值加上指定增量值。
	 * 
	 *            增量也可以为负数，相当于对指定字段进行减法操作。
	 * 
	 *            如果哈希表的 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。
	 * 
	 *            如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0 。
	 * 
	 *            对一个储存字符串值的字段执行 HINCRBY 命令将造成一个错误。
	 * 
	 *            本操作的值被限制在 64 位(bit)有符号数字表示之内。
	 * 
	 */
	public static void hincrBy(String key, String field, int value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.hincrBy(key, field, value);
		} catch (Exception e) {
			logger.error("Set keyex error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * String Redis Incrby 命令将 key 中储存的数字加上指定的增量值。
	 * 
	 * 如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行 INCRBY 命令。
	 * 
	 * 如果值包含错误的类型，或字符串类型的值不能表示为数字，那么返回一个错误。
	 * 
	 * 本操作的值限制在 64 位(bit)有符号数字表示之内。
	 * 
	 * @param key
	 * @param value
	 */
	public static void incrBy(String key, int value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.incrBy(key, value);
		} catch (Exception e) {
			logger.error("Set keyex error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * Hash Redis Hgetall 命令用于返回哈希表中，所有的字段和值。 在返回值里，紧跟每个字段名(field
	 * name)之后是字段的值(value)，所以返回值的长度是哈希表大小的两倍
	 * 
	 * @param key
	 * @return
	 */
	public static Map<String, String> hgetAll(String key) {
		Jedis jedis = null;
		Map<String, String> map = null;
		try {
			if (!key.isEmpty()) {
				jedis = getJedis();
				map = jedis.hgetAll(key);
			}
		} catch (Exception e) {
			logger.error("Set keyex error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
		return map;
	}

	/**
	 * Hash Redis Hset 命令用于为哈希表中的字段赋值 。 如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。
	 * 如果字段已经存在于哈希表中，旧值将被覆盖。
	 * 
	 * @param key
	 * @param field
	 * @param value
	 */
	public static void hset(String key, String field, String value) {
		Jedis jedis = null;
		try {
			value = null == value ? "" : value;
			jedis = getJedis();
			jedis.hset(key, field, value);
		} catch (Exception e) {
			logger.error("Set key error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
	}

	// 删除指定的key
	public static void del(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.del(key);
		} catch (Exception e) {
			logger.error("del keyex error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
	}

	/**
	 * Redis Lrange 返回列表中指定区间内的元素，区间以偏移量 START 和 END 指定。 其中 0 表示列表的第一个元素， 1
	 * 表示列表的第二个元素，以此类推。 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 * 
	 * @param key
	 * @return
	 */
	public static List<String> lrange(final String key) {
		List<String> channelIp = null;
		Jedis jedis = null;
		try {
			jedis = getJedis();
			channelIp = jedis.lrange(key, 0, -1);
		} catch (Exception e) {
			logger.error("del keyex error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
		return channelIp;
	}

	/**
	 * Redis Lpush 命令将一个或多个值插入到列表头部。 如果 key 不存在，一个空列表会被创建并执行 LPUSH 操作。 当 key
	 * 存在但不是列表类型时，返回一个错误。
	 * 
	 * 注意：在Redis 2.4版本以前的 LPUSH 命令，都只接受单个 value 值。
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public static void lpush(String key, String value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.lpush(key, value);
			jedis.expire(key, seconds);

		} catch (Exception e) {
			logger.error("Set list key error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
	}

	public static void lpush(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.lpush(key, value);

		} catch (Exception e) {
			logger.error("Set list key error : " + e);
			jedisPool.close();
		} finally {
			returnResource(jedis);
		}
	}
}

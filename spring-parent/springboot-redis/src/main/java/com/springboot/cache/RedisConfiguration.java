package com.springboot.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

/**
 * redis配置CacheManager
 * 
 * @author maskwang 2017年6月23日
 */
@Configuration
@EnableCaching // 允许缓存
public class RedisConfiguration extends CachingConfigurerSupport {

	/**
	 * 缓存管理器.
	 * 
	 * @param redisTemplate
	 * @return
	 */
	@Bean
	public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
		CacheManager cacheManager = new RedisCacheManager(redisTemplate);
		return cacheManager;
	}

	/**
	 * RedisTemplate缓存操作类,类似于jdbcTemplate的一个类;
	 *
	 * 虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
	 *
	 * 这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们
	 *
	 * 自己的缓存类，比如：RedisStorage类;
	 *
	 * @param factory
	 *            : 通过Spring进行注入，参数在application.properties进行配置；
	 * @return
	 */
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	/**
	 * 自定义key. 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。
	 */
	@Override
	public KeyGenerator keyGenerator() {
		System.out.println("RedisCacheConfig.keyGenerator()");
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				// This will generate a unique key of the class name, the method
				// name
				// and all method parameters appended.
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				System.out.println("keyGenerator=" + sb.toString());
				return sb.toString();
			}
		};
	}
}

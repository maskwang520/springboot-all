### springboot-redis
### 本篇是采用spring cache，用redis做缓存。Dao层是采用的spring data jpa连接数据库
### 技术点：
### 1. 采用spring cache,用@Cacheable就可以把数据存储到redis中去，以及从缓存中取出数据
### 2. 采用spring data jpa。只需继承JpaRepository，即可以实现crud的简单操作。若需要自定义 sql语句，只需要结合@Query注解，即可以实现自定义。以及后面的分页，排序等操作。
### 3. tips:还可以采用RedisUtil这个类实现对redis的存取。
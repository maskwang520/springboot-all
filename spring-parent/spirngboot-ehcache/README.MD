### springboot-ehcache
### 1.缓存配置，ehchache.xml里面，设置一些参数。
### 2.配置cacheManager,再使用注解的地方，都是都是利用cacheManager,产生Cache对象,创建element对象，从而操作缓存
### 3.此处使用的注解形式，若要显式的定义操作缓存，采用以下方式
```java
  Cache cache = manager.getCache(cacheName);  
  Element element = new Element(key, value);
  cache.put(element);    
```
### 上述代码只是简单把key,value放到缓存中去，其他操作都类似。
package com.maskwang;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 配置fastjson
 * @author maskwang
 *2017年6月9日
 */
/**
 * 
 * 
 * 第一种方法就是：
 * 
 * （1）启动类继承extends WebMvcConfigurerAdapter
 * 
 * （2）覆盖方法configureMessageConverters 第二种方法就是： （1）在App.java启动类中，注入Bean :
 * HttpMessageConverters
 * 
 *
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}
   //配置fastjson
	@Bean
	public HttpMessageConverters fastJosonCoverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastJsonConfig.setDateFormat("yy-MM-dd HH:mm:ss am");
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}

}

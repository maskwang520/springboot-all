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
 * ����fastjson
 * @author maskwang
 *2017��6��9��
 */
/**
 * 
 * 
 * ��һ�ַ������ǣ�
 * 
 * ��1��������̳�extends WebMvcConfigurerAdapter
 * 
 * ��2�����Ƿ���configureMessageConverters �ڶ��ַ������ǣ� ��1����App.java�������У�ע��Bean :
 * HttpMessageConverters
 * 
 *
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}
   //����fastjson
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
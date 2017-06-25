package com.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
/**
 * 映入xml配置，把HelloService2注入进去
 * @author maskwang
 *2017年6月17日
 */
@Configuration
@ImportResource(locations={"classpath:application-bean.xml"})
public class XmlConfiguration {
    

}

package com.java.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * 通过该类拿到ApplicationContext,从而访问任意bean
 * 实现在普通类中也能拿到spring容器中的bean
 * @author maskwang
 *2017年6月10日
 */
@Component
public class GetContext implements ApplicationContextAware {
	
	 private static ApplicationContext applicationContext = null;
	 
	 
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(GetContext.applicationContext==null){
			 GetContext.applicationContext=applicationContext;
		}
		  System.out.println("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+GetContext.applicationContext+"========");
     
	}
	
	 //获取applicationContext
    public static ApplicationContext getApplicationContext() {
       return applicationContext;
    }
   
    //通过name获取 Bean.
    public static Object getBean(String name){
       return getApplicationContext().getBean(name);
    }

}

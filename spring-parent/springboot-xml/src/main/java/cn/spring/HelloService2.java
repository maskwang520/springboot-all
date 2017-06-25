package cn.spring;

import org.springframework.stereotype.Service;
/**
 * 不与App.java同包，所以扫描不到，可以通过xml配置扫描到
 * @author maskwang
 *2017年6月17日
 */

@Service
public class HelloService2 {

	public HelloService2() {
		
	    System.out.println("HelloService2.HelloService2()");
	    System.out.println("HelloService2.HelloService2()");
	    System.out.println("HelloService2.HelloService2()");
	}

}

package com.springboot;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * 引入自定义的属性
 * @author maskwang
 *2017年6月15日
 */
@ConfigurationProperties(prefix = "maskwang") //如果不是application文件，须配置location属性
public class MyProperties {
	private String name; //基于松散送绑定，原定义是Name
	private String age;
//	@NotNull     #就会报错
//	private String birthday; //没有定义
	private List<String> employs = new ArrayList<String>();//导入数组
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public List<String> getEmploys() {
		return employs;
	}
	public void setEmploys(List<String> employs) {
		this.employs = employs;
	}
	

}

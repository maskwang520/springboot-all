package com.java.test;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.Service.PersonService;
import com.java.entity.Person;
/**
 * 测试数据库的操作，建立数据库用hibernate的，其他操作可以用jdbcTemplate
 * @author maskwang
 *2017年6月10日
 */
@RestController
@RequestMapping("/person")
public class PersonTest {
  
  @Resource
  PersonService personService;
  @Resource
  JdbcTemplate jdbcTemplate;
  @RequestMapping("/save")
  public String save(){
	  Person p=new Person();
	  p.setName("maskwang");
	  personService.savePerson(p);
	  return "save sucessful";
  }
  
  @RequestMapping("/delete")
  public String delete(){
	  personService.deletePerson(1);
	  return "delete successful";
  }
  
  @RequestMapping("/insert")
  public String insert(){
	  String sql="insert into person(id,name) values(?,?)";
	  jdbcTemplate.update(sql, new Object []{1,"maskwang"});
	  return "insert successful";
  }
  @RequestMapping("select")
  public Person update(@RequestParam("id") int id){
	  String sql="select * from person where id=?";
	  RowMapper<Person> rowMapper = new BeanPropertyRowMapper<Person>(Person.class);
	  return jdbcTemplate.queryForObject(sql, rowMapper,id);
  }
}

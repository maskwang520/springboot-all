package com.java.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.java.entity.Person;
import com.java.repository.PersonRepository;

@Service
public class PersonService {
	@Resource
	private PersonRepository personRepository;
	@Transactional
	public void savePerson(Person p){
		personRepository.save(p);
	}
	@Transactional
	public void deletePerson(long id){
		personRepository.delete(id);
	}
	

}

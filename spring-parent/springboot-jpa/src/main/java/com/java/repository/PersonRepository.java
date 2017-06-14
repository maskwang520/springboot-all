package com.java.repository;

import org.springframework.data.repository.CrudRepository;

import com.java.entity.Person;

public interface PersonRepository extends CrudRepository<Person,Long> {

}

package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}

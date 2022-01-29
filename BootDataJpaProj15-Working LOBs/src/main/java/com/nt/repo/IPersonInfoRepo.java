package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.PersonInfo;

public interface IPersonInfoRepo extends JpaRepository<PersonInfo,Integer> {

}

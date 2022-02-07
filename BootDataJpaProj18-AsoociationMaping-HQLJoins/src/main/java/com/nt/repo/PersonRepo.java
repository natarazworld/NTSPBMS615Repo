package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {
	
	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regNo,ph.contactNo,ph.numberType,ph.provider  from Person p	    inner join  p.phonesInfo ph")
	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regNo,ph.contactNo,ph.numberType,ph.provider  from Person p	    right join  p.phonesInfo ph")
	@Query("SELECT p.pid,p.pname,p.paddrs,ph.regNo,ph.contactNo,ph.numberType,ph.provider  from Person p	   left join  p.phonesInfo ph")
	//@Query("SELECT p.pid,p.pname,p.paddrs,ph.regNo,ph.contactNo,ph.numberType,ph.provider  from Person p	   full  join  p.phonesInfo ph")
	public  List<Object[]>  getDataByJoins();  

}

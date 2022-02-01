package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.repo.PersonRepo;
import com.nt.repo.PhoneNumberRepo;

@Service("otmService")
public class OneToManyMappingMgmtServiceImpl implements IOneToManyMappingMgmtService {
	@Autowired
	private  PersonRepo   personRepo;
	@Autowired
	private  PhoneNumberRepo phoneRepo;

	@Override
	public String saveDataUsingParent(Person person) {
		
		return personRepo.save(person).getPid()+"  Person  is saved";
	}

}

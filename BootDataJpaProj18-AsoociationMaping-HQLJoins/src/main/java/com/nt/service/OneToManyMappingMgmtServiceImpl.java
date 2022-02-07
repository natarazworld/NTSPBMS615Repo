package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repo.PersonRepo;
import com.nt.repo.PhoneNumberRepo;

@Service("otmService")
public class OneToManyMappingMgmtServiceImpl implements IOneToManyMappingMgmtService {
	@Autowired
	private  PersonRepo   personRepo;
	@Autowired
	private  PhoneNumberRepo phoneRepo;
	
	
	@Override
	public List<Object[]> fetchDataByJoins() {
		return personRepo.getDataByJoins();
	}
	
	

	
}//class

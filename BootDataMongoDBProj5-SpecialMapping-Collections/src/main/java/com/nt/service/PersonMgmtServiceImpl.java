package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.document.PersonInfo;
import com.nt.repo.IPersonInfoRepo;

@Service("personService")
public class PersonMgmtServiceImpl implements IPersonInfoMgmtService {
	@Autowired
	private IPersonInfoRepo personRepo;

	@Override
	public String registerPerson(PersonInfo info) {
		return "Person is saved with:"+  personRepo.save(info).getPid();
	}

	

		
}//class

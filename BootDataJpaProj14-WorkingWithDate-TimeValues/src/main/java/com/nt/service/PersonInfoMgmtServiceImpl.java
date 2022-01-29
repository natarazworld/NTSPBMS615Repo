package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.PersonInfo;
import com.nt.repo.IPersonInfoRepo;

@Service("personService")
public class PersonInfoMgmtServiceImpl implements IPersonInfoMgmtService {
	@Autowired
	private IPersonInfoRepo repo;

	@Override
	public String registerPErson(PersonInfo info) {
	      return  repo.save(info).getPid() +"    Person is saved";
		
	}

	@Override
	public List<PersonInfo> fetchAllPersonDetails() {
        return  repo.findAll();
	}

}

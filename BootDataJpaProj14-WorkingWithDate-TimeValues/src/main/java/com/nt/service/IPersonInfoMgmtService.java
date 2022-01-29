package com.nt.service;

import java.util.List;

import com.nt.entity.PersonInfo;

public interface IPersonInfoMgmtService {
	
	public  String registerPErson(PersonInfo info);
	public   List<PersonInfo> fetchAllPersonDetails();

}

package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.repository.IDrivingLicenseRepo;
import com.nt.repository.IPersonRepo;

@Service("rtoService")
public class RTOMgmtServiceImpl implements IRTOMgmtService {
	@Autowired
	private IDrivingLicenseRepo licenseRepo;
	@Autowired
	private  IPersonRepo  personRepo;

	@Override
	public String registerPersonWithDrivingLicense(Person person) {
		return "Person with DrivingLicense is saved with id value ::"+ personRepo.save(person).getPid();
	}
	
	@Override
	public String registerLicenseWithPerson(DrivingLicense license) {
		return "Person with DrivingLicense is saved with id value ::"+ licenseRepo.save(license).getLicenseNo();
	}

	@Override
	public List<Person> fetchAllPersonDetails() {
		return personRepo.findAll();
	}
	
	
	@Override
	public List<DrivingLicense> fetchAllLicenseDetails() {
		return licenseRepo.findAll();
	}

}

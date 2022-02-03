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
	public String saveDataUsingParent(Person person) {
		
		return personRepo.save(person).getPid()+"  Person  is saved";
	}
	
	@Override
	public void loadDataUsingParent() {
	     List<Person> list=personRepo.findAll();
	     list.forEach(per->{
	    	 System.out.println("parent::"+per);
	    	 //get childs of each parent
	    	 Set<PhoneNumber>  childs=per.getPhonesInfo();
	    	 childs.forEach(ph->{
	    		 System.out.println("child::"+ph);
	    	 });
	     });
		
	}//method
	
	@Override
	public String  deleteParentAndItsChilds(int pid) {
		  //Load parent object  
		Optional<Person> opt=personRepo.findById(pid);
		   //Here Along with Parent object the associated child objects will be loaded.
		 if(opt.isPresent()) {
			 personRepo.delete(opt.get());  //if we delete parent obj.. the associated child object will be deleted
			 return "Person  and his PhoneNumbers are deleted";
		 }
		 else {
			 return " Person not found";
		 }
	}
	
	@Override
	public String deleteAllPhoneNumbersOfAPerson(int pid) {
		 //Load Parent object
		  Optional<Person> opt=personRepo.findById(pid);
		  if(opt.isPresent()) {
			  //get childs of a parent
			  Set<PhoneNumber> childs=opt.get().getPhonesInfo();
				/*  childs.forEach(ph->{
					  phoneRepo.delete(ph);
				  });*/
			  phoneRepo.deleteAll(childs);
			  return  "All childs(PhoneNumbers) of a Person are deleted"; 
		  }
		  else {
			  return  "Person not found";
		  }
	}

}//class

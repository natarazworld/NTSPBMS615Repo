package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.document.Tourist;
import com.nt.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		return "Documennt is saved with id value::"+ touristRepo.insert(tourist).getId();
	}

	@Override
	public List<Tourist> fetchAllToursits() {
		return touristRepo.findAll();	
		}
	
	@Override
	public String saveTouristGroup(List<Tourist> tourists) {
	        int count=touristRepo.saveAll(tourists).size();
	        
		return  count+" no.of tourirsts are saved";
	}
	
	@Override
	public List<Tourist> fetchAllToursits(boolean asc, String... properties) {
	           Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC, properties);
	           return  touristRepo.findAll(sort);
	}
	
	@Override
	public Optional<Tourist> fetchTouristById(String id) {
	      Optional<Tourist> opt=touristRepo.findById(id);
	       return opt;
	}
	
	
	@Override
	public String modifyTouristById(String id, long contactNo) {
		  Optional<Tourist> opt=touristRepo.findById(id);
		  if(opt.isPresent()) {
			  Tourist tourist=opt.get();
			  tourist.setContactNo(contactNo);
			  return  touristRepo.save(tourist).getId()+" is updated with new contactNo";
		  }
		  else {
			  return "Document is not found";
		  }
	}
	
	@Override
	public String removeToursitById(String id) {
		  Optional<Tourist> opt=touristRepo.findById(id);
		  if(opt.isPresent()) {
			  Tourist tourist=opt.get();
                touristRepo.delete(tourist);
                return "Document is found and deleted";
               }
		  else {
			  return "Document is not found";
		  }

	}//nethod
	
}//class

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
	public List<Tourist> fetchTouristsByNativePlaceWithRegEx(String nativePlace) {
		return touristRepo.getTouristsByNativePlaceRegEx(nativePlace);
	}
	
	@Override
	public int fetchTouristsCountByAgeRange(int minAge, int maxAge) {
		return touristRepo.getTouristsCountByAgeRange(minAge, maxAge);
	}
	
	@Override
	public List<Tourist> fetchTouristsSortedByName() {
		return touristRepo.getAllTouristsSortedByName();
	}
	
	@Override
	public int deleteTouristsWithNoContactNumber() {
		return touristRepo.deleteTouristsWithNoContactNumber();
	}
	
	@Override
	public boolean IsThereTouristsWithOutVaccination() {
		return touristRepo.isTouristsExistWithOutVaccination();
	}


	
}//class

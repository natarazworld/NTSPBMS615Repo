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
	public List<Tourist> fetchAllTouristByNativePlace(String nativePlace) {
		return touristRepo.getAllTouristsByNativePlace(nativePlace);
	}

	@Override
	public List<Tourist> fetchAllTouristByNativePlaceAndAge(String nativePlace, int minAge) {
		return touristRepo.getAllTouristsByNativePlaceAndAge(nativePlace, minAge);
	}

	@Override
	public List<Tourist> fetchAllTouristByAgeRange(int minAge, int maxAge) {
		return touristRepo.getAllTouristsByAgeRange(minAge, maxAge);
	}
	
	
	@Override
	public List<Tourist> fetchAllTouristsByNativePlaces(String nativePlace1, String nativePlace2) {
	
		return touristRepo.getAllTouristsByNativePlaces(nativePlace1, nativePlace2);
	}
	
	@Override
	public List<Object[]> fetchTouristDataByNativePlace(String nativePlace) {
	   return touristRepo.getTouristDataByNativePlace(nativePlace);
	}
	
	@Override
	public List<Object[]> fetchTouristDataByNativePlaces(String nativePlace1, String nativePlace2,
			String nativePlace3) {
		return touristRepo.getTouristDataByNativePlace(nativePlace1,nativePlace2,nativePlace3);
	}

	
}//class

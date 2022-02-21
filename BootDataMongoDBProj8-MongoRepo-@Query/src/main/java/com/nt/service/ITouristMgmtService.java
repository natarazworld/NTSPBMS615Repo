package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.document.Tourist;

public interface ITouristMgmtService {

	public List<Tourist>  fetchAllTouristByNativePlace(String nativePlace);
	public List<Tourist>  fetchAllTouristByNativePlaceAndAge(String nativePlace,int minAge);
	public  List<Tourist> fetchAllTouristByAgeRange(int minAge,int maxAge);
	public  List<Tourist> fetchAllTouristsByNativePlaces(String nativePlace1,String nativePlace2);
	public  List<Object[]> fetchTouristDataByNativePlace(String nativePlace);
	public  List<Object[]> fetchTouristDataByNativePlaces(String nativePlace1,String nativePlace2,String nativePlace3);
}

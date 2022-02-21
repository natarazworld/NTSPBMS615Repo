package com.nt.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Tourist;

public interface ITouristRepo extends MongoRepository<Tourist, String> {
	
	//====== using regex ===========
	@Query(value="{nativePlace:{$regex:?0} }")
	public  List<Tourist>   getTouristsByNativePlaceRegEx(String nativePlace);
	
	//==== using  count ================
	@Query(value="{age:{$gte:?0,$lte:?1} }", count = true)
     public  int   getTouristsCountByAgeRange(int minAge, int maxAge);
	
	@Query(value="{}", sort = "{touristName:1}")  // 1 indicates  asc order , -1 indicates desc order
	public  List<Tourist> getAllTouristsSortedByName();
	
	@Query(value="{contactNo:null}", delete = true)
	public  int  deleteTouristsWithNoContactNumber();
	
	@Query(value="{isVaccinated:false}",exists = true)
	public  boolean  isTouristsExistWithOutVaccination();
	
}

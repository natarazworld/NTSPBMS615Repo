package com.nt.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Tourist;

public interface ITouristRepo extends MongoRepository<Tourist, String> {
	
	//=============== Entity  Queries ===================
	
	//@Query(fields ="{}", value= "{nativePlace:?0}")  //to select all filed values (or)
	@Query( value= "{nativePlace:?0}")  //to select all filed values (or)
	public List<Tourist> getAllTouristsByNativePlace(String nativePlace);
	
	
	@Query( value= "{nativePlace:?0,age:{$gte:?1}}")  // applies   nativePlace=? and age>=? 
	public List<Tourist> getAllTouristsByNativePlaceAndAge(String nativePlace,int minAge);  
	
	//@Query( value= "{age:{$gte:?0,$lte:?1}}")  // applies  age>=? and age<=? (or)
	@Query( value= "{age:{$gte:?0},age:{$lte:?1}}")  // applies  age>=? and age<=?
	public List<Tourist> getAllTouristsByAgeRange(int startAge,int endPage);  
	
	@Query( value= "{$or:[{nativePlace:?0},{nativePlace:?1}]}")  // applies  nativePlace>=? or nativePlace<=?
	public List<Tourist> getAllTouristsByNativePlaces(String nativePlace1,String nativePlace2);  
	
	//=========================== Projections(selecting specific single column or multiple col values ================
	
	@Query(fields="{touristName:1,nativePlace:1,age:1}",value= "{nativePlace:?0}")  
	   //gives  select  id,touristName,nativePlace,age from  Tourist where nativePlace=?
	public List<Object[]> getTouristDataByNativePlace(String nativePlace);
	
	
	@Query(fields="{id:0,touristName:1,nativePlace:1,age:1,contactNo:1}",value= "{nativePlace:{$in:[?0,?1,?2]}}")  
	   //gives  select  id,touristName,nativePlace,age from  Tourist where nativePlace=?
	public List<Object[]> getTouristDataByNativePlace(String nativePlace1,String nativePlace2,String nativePlace3);  
	
	
	
}

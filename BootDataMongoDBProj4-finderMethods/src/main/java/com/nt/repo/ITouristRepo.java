package com.nt.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Tourist;

public interface ITouristRepo extends MongoRepository<Tourist,String> {
	public List<Tourist>  findByNativePlaceOrderByTouristNameAsc(String nativePlace);
	public Tourist   findByContactNo(long contactNo);
	
}

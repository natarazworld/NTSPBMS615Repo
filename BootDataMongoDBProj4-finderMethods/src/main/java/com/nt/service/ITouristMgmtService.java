package com.nt.service;

import java.util.List;

import com.nt.document.Tourist;

public interface ITouristMgmtService {
	public List<Tourist>  fetchTouristsByNativePlaceAscOrder(String nativePlace);  
	public  Tourist   fetchTouristByContactNo(long contactNo);   
}

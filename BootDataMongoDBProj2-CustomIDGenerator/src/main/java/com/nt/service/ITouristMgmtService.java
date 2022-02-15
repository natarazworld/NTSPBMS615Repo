package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.document.Tourist;

public interface ITouristMgmtService {
	public   String registerTourist(Tourist tourist);
	public     List<Tourist>  fetchAllToursits();
	public    String    saveTouristGroup(List<Tourist> tourists);
	public  List<Tourist>  fetchAllToursits(boolean  asc, String  ...properties);
	public    Optional<Tourist>    fetchTouristById(String id);
	public   String   modifyTouristById(String id , long contactNo);
	public  String  removeToursitById(String id);
}

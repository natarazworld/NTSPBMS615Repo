package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.document.Tourist;

public interface ITouristMgmtService {
     public  List<Tourist>  fetchTouristsByNativePlaceWithRegEx(String nativePlace);
     public  int  fetchTouristsCountByAgeRange(int minAge,int maxAge);
     public  List<Tourist>  fetchTouristsSortedByName();
     public   int   deleteTouristsWithNoContactNumber();
     public   boolean  IsThereTouristsWithOutVaccination();
}

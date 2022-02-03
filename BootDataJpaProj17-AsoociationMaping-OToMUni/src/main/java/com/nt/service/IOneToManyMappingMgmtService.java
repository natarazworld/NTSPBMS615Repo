package com.nt.service;

import com.nt.entity.Person;

public interface IOneToManyMappingMgmtService {
     public   String   saveDataUsingParent(Person person);
     public   void   loadDataUsingParent();
     public  String   deleteParentAndItsChilds(int pid);
     public  String  deleteAllPhoneNumbersOfAPerson(int pid);
}

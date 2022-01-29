package com.nt.service;

import java.util.List;

import com.nt.entity.EmployeeInfo;

public interface IEmployeeMgmtService {
	 public String registerEmployee(EmployeeInfo info);
	 public   List<EmployeeInfo>  getAllEmpDetails();
	 

}

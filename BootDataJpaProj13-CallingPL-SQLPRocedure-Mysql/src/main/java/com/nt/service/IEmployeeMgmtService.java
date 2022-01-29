package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	public  List<Employee>  fetchEmpDetailsByDesgs(String desg1,String desg2);

}

package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
       public  Page<Employee>  getEmployeesPageData(Pageable pageable);
       public  String  registerEmployee(Employee emp); 
       public  Employee   getEmployeeByNo(int no);
       public  String   editEmployee(Employee emp);
       public  String   deleteEmployee(int no);
}

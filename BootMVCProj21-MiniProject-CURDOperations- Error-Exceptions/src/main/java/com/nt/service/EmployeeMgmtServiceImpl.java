package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;


@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
       int idVal=empRepo.save(emp).getEmpno();
		return "Employee is saved with the id value ::"+idVal; 
	}

	@Override
	public Employee getEmployeeByNo(int no){
		Optional<Employee> opt=empRepo.findById(no);
		if(opt.isEmpty())
			throw new EmployeeNotFoundException(no+" emp not found");
		return opt.get();
	}

	@Override
	public String editEmployee(Employee emp) {
	       int idVal=empRepo.save(emp).getEmpno();  //save(-)  method can perform both save /edit operations
			return idVal+" Employee is updated "; 

	}
	
	@Override
	public String deleteEmployee(int no) {
		  empRepo.deleteById(no);
		  return no+" emp no Employee is deleted";
	}

}

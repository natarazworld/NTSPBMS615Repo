package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}

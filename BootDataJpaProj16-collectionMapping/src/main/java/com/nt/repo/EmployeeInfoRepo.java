package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.EmployeeInfo;

public interface EmployeeInfoRepo extends JpaRepository<EmployeeInfo, Integer> {

}

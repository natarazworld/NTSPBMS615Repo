package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.PhoneNumber;

public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, Integer> {

}

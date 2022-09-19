package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.IPLPlayer;

public interface IIPLPlayerRepository extends JpaRepository<IPLPlayer, Integer> {

}

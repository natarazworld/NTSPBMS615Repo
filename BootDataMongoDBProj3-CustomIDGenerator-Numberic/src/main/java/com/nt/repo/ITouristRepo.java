package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Tourist;

public interface ITouristRepo extends MongoRepository<Tourist, Integer> {
}

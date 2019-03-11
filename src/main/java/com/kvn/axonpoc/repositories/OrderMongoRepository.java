package com.kvn.axonpoc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kvn.axonpoc.domain.entities.OrderMongoEntity;

public interface OrderMongoRepository extends MongoRepository<OrderMongoEntity, String>{
	

}

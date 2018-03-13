package com.dungnv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dungnv.collection.User;

public interface UserRepository extends MongoRepository<User, String>{

}

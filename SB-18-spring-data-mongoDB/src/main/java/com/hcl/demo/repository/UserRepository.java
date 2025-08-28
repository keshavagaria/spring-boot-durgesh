package com.hcl.demo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.hcl.demo.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{

	User findByUsername(String userName);

}

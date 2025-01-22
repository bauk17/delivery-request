package com.caua.deliveryrequest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.caua.deliveryrequest.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

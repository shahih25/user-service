package com.hs.userservice.repository;

import com.hs.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, String> {
}

package com.example.cafe.Repository;

import com.example.cafe.entity.Users;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryRepository extends MongoRepository<Users, ObjectId> {
    Users findByUserName(String username);
}

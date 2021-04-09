package com.osm.streamiiapp.dao;

import com.osm.streamiiapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends MongoRepository<User, String> {
}

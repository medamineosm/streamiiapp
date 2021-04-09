package com.osm.streamiiapp.dao;

import com.osm.streamiiapp.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao extends ReactiveMongoRepository<Account, String> {
    List<Account> findByUserId(String userId );
}

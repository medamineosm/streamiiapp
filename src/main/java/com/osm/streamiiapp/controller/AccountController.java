package com.osm.streamiiapp.controller;

import com.osm.streamiiapp.dao.AccountDao;
import com.osm.streamiiapp.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
@RestController
public class AccountController {
    @Autowired
    private AccountDao accountDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/account", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> saveTodoData( @RequestBody Account account){
        accountDao.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/account")
    public ResponseEntity<Flux<Account>> fetchAllAccountData(){
        Flux<Account> account = accountDao.findAll();
        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/account/{id}")
    public ResponseEntity<List<Account>> fetchAccountData(@PathVariable("id") String id){
        List<Account> account = accountDao.findByUserId(id);
        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/account/{id}")
    public ResponseEntity<Account> deleteById(@PathVariable("id") String id){
        accountDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

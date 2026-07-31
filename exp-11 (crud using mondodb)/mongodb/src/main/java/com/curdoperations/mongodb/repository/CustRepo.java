package com.curdoperations.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.curdoperations.mongodb.model.Customer;

public interface CustRepo extends MongoRepository<Customer, Integer>{

}

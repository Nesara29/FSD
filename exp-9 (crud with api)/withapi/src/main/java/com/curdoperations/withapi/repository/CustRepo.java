package com.curdoperations.withapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.curdoperations.withapi.model.Customer;

public interface CustRepo extends CrudRepository<Customer, Integer>{

}

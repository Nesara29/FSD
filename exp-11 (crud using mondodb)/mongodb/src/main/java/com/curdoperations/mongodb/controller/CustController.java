package com.curdoperations.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curdoperations.mongodb.model.Customer;
import com.curdoperations.mongodb.repository.CustRepo;

@RestController
public class CustController {
	
	@Autowired
	CustRepo custrepo;
	
	@RequestMapping("/addCust")
	public String addCust(@RequestBody Customer customer) {
		custrepo.save(customer);
		return "Record Inserted Successfully";
	}
	
	@GetMapping("/getCust")
	public List<Customer> getCust(){
		return custrepo.findAll();
	}
	@DeleteMapping("/delCust/{cid}")
	public String delCust(@PathVariable int cid) {
		custrepo.deleteById(cid);
		return "record Deleted Successfully";
	}
	@PutMapping("/updCust")
		public String updcust(@RequestBody Customer customer) {
			Customer newCust=custrepo.findById(customer.getCid()).get();
			newCust.setFname(customer.getFname());
			newCust.setLname(customer.getLname());
			custrepo.save(newCust);
			return "Record updated sucessfully";
		}
	}


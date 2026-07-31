package com.curdoperations.withapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curdoperations.withapi.model.Customer;
import com.curdoperations.withapi.repository.CustRepo;

@RestController
public class CustController {

	@Autowired
	CustRepo custrepo;
	
	@PostMapping("/addCust")
	public String addCust(@RequestBody Customer customer) {
		custrepo.save(customer);
		return "Record Inserted Successfully";
	}
	
	@GetMapping("/getCust")
	public List<Customer> getCust(){
		return (List<Customer>)custrepo.findAll();
	}
	
	@DeleteMapping("/delCust/{cid}")
	public String delEmp(@PathVariable int cid) {
		custrepo.deleteById(cid);
		return "Record Delete Sucessfully";
	}
	
	@PutMapping("/updCust")
	public String updEmp(@RequestBody Customer customer) {
		Customer custupdate=custrepo.findById(customer.getCid()).get();
		custupdate.setFname(customer.getFname());
		custupdate.setLname(customer.getLname());
		custupdate.setLocation(customer.getLocation());
		custrepo.save(customer);
		return "Successfully updated record";
	}
}

package com.mtd.EcomApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtd.EcomApp.entity.Customer;
import com.mtd.EcomApp.entity.LoginCustomer;
import com.mtd.EcomApp.repository.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	 private CustomerRepository repo;
	
	
	@PostMapping(path="/signUp")
	 public Customer signUp(@RequestBody Customer customer) {
	     customer.setId(null) ;
	     Customer savedCustomer=repo.save(customer);
	     return savedCustomer;
	}
	
	@PostMapping(path="/login")
	public String login(@RequestBody LoginCustomer loginCustomer) {
		//jwt -token based authentication
		Customer customer = repo.findByEmail(loginCustomer.getEmail());
		return "token" + customer.getId();
	}

}

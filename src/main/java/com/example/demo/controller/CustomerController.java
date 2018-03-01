package com.example.demo.controller;

import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.*;
import com.example.demo.repo.*;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository cusrepo;
	
	@GetMapping(value="/customer", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Customer> getAll() {
		List<Customer> list = new ArrayList<>();
		Iterable<Customer> customers = cusrepo.findAll();
		customers.forEach(list::add);
		return list;
		}
	/*@RequestMapping(value="/customer")
public void abc()
{
	System.out.println("inside ABC");
}*/
	
	
	@PostMapping(value="/postcustomer")
	public Customer postCustomer(@RequestBody Customer customer) {
		cusrepo.save(new Customer(customer.getFirstname(),customer.getLastname()));
		return customer;
	}
	
	@GetMapping(value="/findbylastname/{lastname}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findbyLastName(@PathVariable String lastname)
	{
		List<Customer>customers = cusrepo.findBylastname(lastname);
		return customers;
	}
	
	@DeleteMapping(value="/customer/{id}")
	public void deleteCustomer(@PathVariable long id)
	{
		cusrepo.delete(id);
	}

}

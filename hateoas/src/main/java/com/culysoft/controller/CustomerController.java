package com.culysoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.culysoft.exception.CustomerNotFoundException;
import com.culysoft.model.Customer;
import com.culysoft.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> getAll() {
		List<Customer> customers = new ArrayList<>();
		
		customerService.getAll().forEach(c -> {
			Link link = Link.of("http://localhost:8080/customers/customer/" + c.getId());
			c.add(link);
			customers.add(c);
		});
		
		return customers;
	}
	
	@GetMapping("/customer/{id}")
	public Customer getById(@PathVariable Long id)  throws CustomerNotFoundException{
		Customer customer = customerService.getById(id);
		Link link = Link.of("http://localhost:8080/customers");
		customer.add(link);
		return customer;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer save(@Validated @RequestBody Customer customer) {
		System.out.println(customer.getName() + " " + customer.getCompanyName());
		Customer customerCreated = customerService.save(customer);
		Link link = Link.of("http://localhost:8080/customers");
		customerCreated.add(link);
		return customerCreated;
	}
	
	@PutMapping
	public Customer update(@Validated @RequestBody Customer customer) {
		Customer customerUpdated = customerService.save(customer);
		Link link = Link.of("http://localhost:8080/customers");
		customerUpdated.add(link);
		return customerUpdated;
	}
	
	@DeleteMapping("customer/{id}")
	public String delete(@PathVariable Long id) {
		customerService.delete(id);
		Link link = Link.of("http://localhost:8080/customers");
		return link.getHref();
	}

}

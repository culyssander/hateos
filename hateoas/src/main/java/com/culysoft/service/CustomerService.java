 package com.culysoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.culysoft.exception.CustomerNotFoundException;
import com.culysoft.model.Customer;
import com.culysoft.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}
	
	public Customer getById(Long id) throws CustomerNotFoundException {
		return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("Customer not found."));
	}
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void delete(Long id) {
		customerRepository.deleteById(id);
	}

}

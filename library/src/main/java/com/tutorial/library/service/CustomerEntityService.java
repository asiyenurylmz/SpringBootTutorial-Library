package com.tutorial.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.library.entity.CustomerEntity;
import com.tutorial.library.repository.CustomerRepository;

@Service
public class CustomerEntityService {
	@Autowired
	private CustomerRepository repository;
	
	public CustomerEntity save(CustomerEntity customer) {
		return repository.save(customer);
	}
	
	public Optional<CustomerEntity> save(Long id) {
		return repository.findById(id);
	}
}

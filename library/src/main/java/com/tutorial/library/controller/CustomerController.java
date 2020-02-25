package com.tutorial.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.library.dto.CustomerDTO;
import com.tutorial.library.entity.CustomerEntity;
import com.tutorial.library.service.CustomerEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
	private final CustomerEntityService customerEntityService;
	
	
//	@GetMapping("/{id}")
//	public CustomerDTO findById(@PathVariable Long id) {
//		return customerEntityService.findById(id);
//
//	}
	
	@PutMapping("/add")
	public CustomerEntity add(@RequestBody CustomerDTO customerDTO) {
		return customerEntityService.save(customerDTO);
	}
	
//	@PutMapping("/add")
//	public CustomerEntity add(@RequestBody CustomerEntity entity) {
//		return customerEntityService.save(entity);
//	}

}

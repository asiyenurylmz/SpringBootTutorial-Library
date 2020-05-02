package com.tutorial.library.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.library.dto.CustomerDTO;
import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.CustomerEntity;
import com.tutorial.library.entity.RentEntity;
import com.tutorial.library.exception.EntityNotFoundException;
import com.tutorial.library.service.CustomerEntityService;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
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

	@GetMapping("/all")
	CollectionModel<EntityModel<CustomerEntity>> all() {
		List<EntityModel<CustomerEntity>> customers = customerEntityService.findAll().stream()
				.map(customer -> new EntityModel<>(customer,
						linkTo(methodOn(CustomerController.class).one(customer.getId())).withSelfRel(),
						linkTo(methodOn(CustomerController.class).all()).withRel("customers")))
				.collect(Collectors.toList());

		return new CollectionModel<>(customers, linkTo(methodOn(CustomerController.class).all()).withSelfRel());
	}

	@GetMapping("/{id}")
	EntityModel<CustomerEntity> one(@PathVariable Long id) {
		CustomerEntity customer = customerEntityService.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
		return new EntityModel<CustomerEntity>(customer, linkTo(methodOn(CustomerController.class).one(id)).withSelfRel(),
				linkTo(methodOn(CustomerController.class).all()).withRel("CustomerList"));
	}
}

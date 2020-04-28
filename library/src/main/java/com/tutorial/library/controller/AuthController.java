package com.tutorial.library.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutorial.library.entity.CustomerEntity;
import com.tutorial.library.model.request.RequestLogin;
import com.tutorial.library.service.CustomerEntityService;
import com.tutorial.library.session.CustomSession;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final CustomerEntityService customerEntityService;
	private final CustomSession session;

	@PostMapping("/login")
	public ResponseEntity<Long> login(@RequestBody RequestLogin request) {
		CustomerEntity customer = customerEntityService.login(request.getUsername(), request.getPassword());
		session.setCustomerEntity(customer);
		return ResponseEntity.ok(customer.getId());
//		EntityModel<CustomerEntity> customerEntity=new EntityModel<CustomerEntity>(customer, 
//				linkTo(methodOn(CustomerController.class).one(customer.getId())).withSelfRel());
		
	}


	@GetMapping("/logout")
	public ResponseEntity<Boolean> logout() {
		if(ObjectUtils.isEmpty(session.getCustomerEntity())) {
			throw new RuntimeException("User already logout");
		}
		session.setCustomerEntity(null);
		return ResponseEntity.ok(Boolean.TRUE);
	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Boolean> test(@PathVariable Long customerId) {
		return ResponseEntity.ok(session.getCustomerEntity().getId().compareTo(customerId) == 0);
	}
}
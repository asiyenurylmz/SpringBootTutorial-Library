package com.tutorial.library.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.tutorial.library.dto.CustomerDTO;
import com.tutorial.library.entity.CustomerEntity;
import com.tutorial.library.exception.InvalidCredentialException;
import com.tutorial.library.repository.CustomerRepository;
import com.tutorial.library.util.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerEntityService {
	// @Autowired
	private final CustomerRepository repository;
	private final Mapper mapper;

//	public CustomerEntity save(CustomerEntity customer) {
//		return repository.save(customer);
//	}

	public CustomerEntity save(CustomerDTO customer) {
		CustomerEntity entity= mapper.mapDtoToEntity(customer);
		return repository.save(entity);
	}

	public Optional<CustomerEntity> save(Long id) {
		return repository.findById(id);
	}

	public CustomerEntity login(String name, String password) {
		return repository.findByUsernameAndPassword(name, password).orElseThrow(InvalidCredentialException::new);
	}

//	public CustomerEntity findById(Long id) {
//		return repository.findById(id).orElseThrow(EntityNotFoundException::new);
//	}
	public Optional<CustomerEntity> findById(Long id) {
		return repository.findById(id);
	}
}

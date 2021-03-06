package com.tutorial.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.library.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	Optional<CustomerEntity> findByUsernameAndPassword(String username, String password);
	
	Optional<CustomerEntity> findById(Long id);
	
//	Optional<CustomerEntity> findByEmail(Email email);

	Optional<CustomerEntity> findByLatitude(Long latitude);

	Optional<CustomerEntity> findByLongitude(Long longitude);
}

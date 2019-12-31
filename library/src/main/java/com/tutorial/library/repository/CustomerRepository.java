package com.tutorial.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.library.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	Optional<CustomerEntity> findByName(String name);
//	Optional<CustomerEntity> findBye_mail(String e_mail);
//	Optional<CustomerEntity> findByMail(String mail);
//	Optional<CustomerEntity> findByE_mail(String mail);
	Optional<CustomerEntity> findById(Long id);
	Optional<CustomerEntity> findByLatitude(Long latitude);
	Optional<CustomerEntity> findByLongitude(Long longitude);
}

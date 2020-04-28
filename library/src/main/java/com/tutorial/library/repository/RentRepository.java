package com.tutorial.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.library.entity.CustomerEntity;
import com.tutorial.library.entity.RentEntity;
import com.tutorial.library.entity.StockEntity;

@Repository
public interface RentRepository extends JpaRepository<RentEntity, Long> {

	
	Optional<RentEntity> findById(Long id);
	List<RentEntity> findByCustomer(CustomerEntity customer);
	Optional<RentEntity> findByStock(StockEntity stock);
}

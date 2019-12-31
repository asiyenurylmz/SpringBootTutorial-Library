package com.tutorial.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.library.entity.LibraryEntity;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {
	List<LibraryEntity> findByCity(String city);

	List<LibraryEntity> findByCityAndDistrict(String city, String district);
}

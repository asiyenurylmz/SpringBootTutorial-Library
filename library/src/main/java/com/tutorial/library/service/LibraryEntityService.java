package com.tutorial.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.repository.LibraryRepository;

@Service
public class LibraryEntityService {
	@Autowired
	private LibraryRepository repository;
	
	public LibraryEntity save(LibraryEntity book) {
		return repository.save(book);
	}
	
	public Optional<LibraryEntity> save(Long id) {
		return repository.findById(id);
	}
	
	public List<LibraryEntity> findByCity(String city){
		return repository.findByCity(city);
	}
	
	public List<LibraryEntity> findByCityAndDistrict(String city, String district){
		return repository.findByCityAndDistrict(city, district);
	}
}

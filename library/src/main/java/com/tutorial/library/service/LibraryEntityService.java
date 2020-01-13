package com.tutorial.library.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.model.BookDTO;
import com.tutorial.library.repository.LibraryRepository;

@Service
public class LibraryEntityService {
	@Autowired
	private LibraryRepository repository;
	
	public LibraryEntity save(LibraryEntity library) {
		return repository.save(library);
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
	
	public List<LibraryEntity> findAll(){
		return repository.findAll();
	}

	public Optional<LibraryEntity> findById(Long id) {
		return repository.findById(id);
	}
	
	public Optional<LibraryEntity> findByName(String name) {
		return repository.findByName(name);
	}
}

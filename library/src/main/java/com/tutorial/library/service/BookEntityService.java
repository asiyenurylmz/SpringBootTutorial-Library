package com.tutorial.library.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookEntityService {
	@Autowired
	private BookRepository repository;
	
	public BookEntity save(BookEntity book) {
		return repository.save(book);
	}
	
	public Optional<BookEntity> save(Long id) {
		return repository.findById(id);
	}
	
	public void remove(BookEntity book) {
		repository.delete(book);
		log.info("Book: " + book + " removed.");
	}
	
	public void remove(Long id) {
		BookEntity book = repository.findById(id).orElseThrow(EntityNotFoundException::new);
		remove(book);
	}
	
	public Optional<BookEntity> findByName(String name){
		return repository.findByName(name);
	}
	
	public Optional<BookEntity> findById(int id){
		return repository.findById(id);
	}
}

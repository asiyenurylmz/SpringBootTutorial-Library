package com.tutorial.library.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.model.BookDTO;
import com.tutorial.library.service.BookEntityService;
import com.tutorial.library.util.Mapper;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookEntityService bookEntityService;

	@Autowired
	private Mapper mapper;

//	@RequestMapping(method = RequestMethod.GET, path = "/all")
	@GetMapping("/all")
	public List<BookEntity> getAllBooks() {
		return bookEntityService.findAll();

	}

	@GetMapping("/{id}")
	public BookDTO findById(@PathVariable Long id) {
		return mapper.mapEntityToDto(bookEntityService.findById(id).orElseThrow(EntityNotFoundException::new));

	}

	@PutMapping("/add")
	public BookEntity add(@RequestBody BookEntity book) {
		return bookEntityService.save(book);

	}
}

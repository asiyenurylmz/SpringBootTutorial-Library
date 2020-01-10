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

import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.model.LibraryDTO;
import com.tutorial.library.service.LibraryEntityService;
import com.tutorial.library.util.Mapper;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryEntityService libraryEntityService;

	@Autowired
	private Mapper mapper;

	@GetMapping("/all")
	public List<LibraryEntity> getallLibraries() {
		return libraryEntityService.findAll();
	}

	@GetMapping("/{id}")
	public LibraryDTO findById(@PathVariable Long id) {
		return mapper.mapEntityToDto(libraryEntityService.findById(id).orElseThrow(EntityNotFoundException::new));
	}

	@PutMapping("/add")
	public LibraryEntity add(@RequestBody LibraryEntity library) {
		return libraryEntityService.save(library);
	}

}

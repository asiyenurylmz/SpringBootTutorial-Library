package com.tutorial.library.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import com.tutorial.library.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.library.dto.LibraryDTO;
import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.service.LibraryEntityService;
import com.tutorial.library.util.Mapper;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryEntityService libraryEntityService;

	@Autowired
	private Mapper mapper;

//	@GetMapping("/all")
//	public List<LibraryEntity> getallLibraries() {
//		return libraryEntityService.findAll();
//	}

//	@GetMapping("/{id}")
//	public LibraryDTO findById(@PathVariable Long id) {
//		return mapper.mapEntityToDto(libraryEntityService.findById(id).orElseThrow(EntityNotFoundException::new));
//	}

	@PutMapping("/add")
	public LibraryEntity add(@RequestBody LibraryEntity library) {
		return libraryEntityService.save(library);
	}

	@GetMapping("/{id}")
	EntityModel<LibraryEntity> one(@PathVariable Long id) {
		LibraryEntity library = libraryEntityService.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
		return new EntityModel<>(library, linkTo(methodOn(LibraryController.class).one(id)).withSelfRel(),
				linkTo(methodOn(LibraryController.class).all()).withRel("Libraries"));
	}
	
	@GetMapping("/all")
	CollectionModel<EntityModel<LibraryEntity>> all() {
		List<EntityModel<LibraryEntity>> libraries = libraryEntityService.findAll().stream()
				.map(library -> new EntityModel<>(library,
						linkTo(methodOn(LibraryController.class).one(library.getId())).withSelfRel(),
						linkTo(methodOn(LibraryController.class).all()).withRel("Libraries")))
				.collect(Collectors.toList());

		return new CollectionModel<>(libraries, linkTo(methodOn(LibraryController.class).all()).withSelfRel());
	}
}

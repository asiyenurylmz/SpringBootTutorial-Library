package com.tutorial.library.controller;

import com.tutorial.library.exception.*;
import com.tutorial.library.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.tutorial.library.dto.BookDTO;
import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.service.BookEntityService;
import com.tutorial.library.util.Mapper;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookEntityService bookEntityService;

	@Autowired
	private Mapper mapper;

////	@RequestMapping(method = RequestMethod.GET, path = "/all")
//	@GetMapping("/all")
//	public List<BookEntity> getAllBooks() {
//		return bookEntityService.findAll();
//
//	}

	@GetMapping("/all")
	CollectionModel<EntityModel<BookEntity>> all() {
		List<EntityModel<BookEntity>> books = bookEntityService.findAll().stream()
				.map(book -> new EntityModel<>(book,
						linkTo(methodOn(BookController.class).one(book.getId())).withSelfRel(),
						linkTo(methodOn(BookController.class).all()).withRel("books")))
				.collect(Collectors.toList());

		return new CollectionModel<>(books, linkTo(methodOn(BookController.class).all()).withSelfRel());
	}
//	CollectionModel<EntityModel<BookEntity>> all(){
//		List<EntityModel<BookEntity>> books= bookEntityService.findAll().stream().
//				map(book -> new EntityModel<>(book, linkTo(methodOn(BookController.class).one(book.getId())).withSelfRel(), 
//						linkTo(methodOn(BookController.class).all()).withRel("books"))).collect(Collectors.toList());

//	@GetMapping("/employees")
//	CollectionModel<EntityModel<Employee>> all() {
////		List<EntityModel<Employee>> employees = repository.findAll().stream()
////				.map(employee -> new EntityModel<>(employee,
////						linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
////						linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
////				.collect(Collectors.toList());
//
//		List<EntityModel<Employee>> employees = repository.findAll().stream().map(assembler::toModel)
//				.collect(Collectors.toList());
//		return new CollectionModel<>(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
//	}
//	@GetMapping("/{id}")
//	public BookDTO findById(@PathVariable Long id) {
//		return mapper.mapEntityToDto(bookEntityService.findById(id).orElseThrow(EntityNotFoundException::new));
//
//	}

	@GetMapping("/{id}")
	EntityModel<BookEntity> one(@PathVariable Long id) {
		BookEntity book = bookEntityService.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
		return new EntityModel<>(book, linkTo(methodOn(BookController.class).one(id)).withSelfRel(),
				linkTo(methodOn(BookController.class).all()).withRel("Books"));
	}

//	@GetMapping("/{id}")
//	EntityModel<Employee> one(@PathVariable Long id) {
//		Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
//
////		return new EntityModel<>(employee, linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
////				linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
//
//		return assembler.toModel(employee);
//	}

	@PutMapping("/add")
	public BookEntity add(@RequestBody BookEntity book) {
		return bookEntityService.save(book);

	}
}

package com.tutorial.library.controller;

import java.util.*;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutorial.library.dto.BookDTO;
import com.tutorial.library.dto.RentDTO;
import com.tutorial.library.dto.StockDTO;
import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.CustomerEntity;
import com.tutorial.library.entity.RentEntity;
import com.tutorial.library.entity.StockEntity;
import com.tutorial.library.service.BookEntityService;
import com.tutorial.library.service.CustomerEntityService;
import com.tutorial.library.service.LibraryEntityService;
import com.tutorial.library.service.RentEntityService;
import com.tutorial.library.service.StockEntityService;
import com.tutorial.library.session.CustomSession;
import com.tutorial.library.util.Mapper;

import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentController {

	@Autowired
	private CustomSession session;
	private final RentEntityService rentEntityService;
	private final CustomerEntityService customerEntityService;
	private final StockEntityService stockEntityService;
	private final BookEntityService bookEntityService;
	private final LibraryEntityService libraryEntityService;
	
	private final Mapper mapper;

//	@PutMapping("/add")
//	public RentEntity add(@RequestBody RentDTO rentDTO) {
//		return rentEntityService.save(rentDTO);
//	}

	@PutMapping("/add")
	public ResponseEntity<Long> add(@RequestBody StockDTO stockDTO) {
		StockDTO stockDTO_=mapper.mapEntityToDto(stockEntityService.findById(stockDTO.getId()).orElseThrow());
		RentDTO rentDTO = new RentDTO();
		CustomerEntity entity = session.getCustomerEntity();
		rentDTO.setCustomer(mapper.mapEntityToDto(customerEntityService.findById(entity.getId()).orElseThrow()));
		rentDTO.setStock(mapper.mapEntityToDto(stockEntityService.findByLibraryAndBook(
				libraryEntityService.findById(stockDTO_.getLibrary().getId()).orElseThrow(),
				bookEntityService.findById(stockDTO_.getBook().getId()).orElseThrow())));
				rentEntityService.save(rentDTO);
		return ResponseEntity.ok(rentDTO.getId());

	}
	
//	@GetMapping("/owned")
//	public List<EntityModel<StockEntity>> list(){
//		List<EntityModel<StockEntity>> rentedList=
//		
//		
////		List<EntityModel>
//	//	List<RentEntity> rentedList= rentEntityService.findByUserId(session.getCustomerEntity().getId());
//		//		stream().collect(Collectors.toList());
//	//	return rentedList;
//	}	
//				
//				
//				//map(rentedList -> new EntityModel<>(rentedList, linkTo(methodOn(BookEntityService.class).
//				//		findById(rentedList.getStock().getBook().getId()).withSelfRel())).collect(Collectors.toList()));
////		List<EntityModel<RentEntity>> rentedList= rentEntityService.findByUserId(session.getCustomerEntity().getId()).stream().
////				map(rentedList-> new EntityModel<>(books, linkTo(methodOn(BookController.class).one(rentedList.getId()))).withselfRel(), 
////						linkTo(methodOn(RentController.class).all()).withRel("RentedList"))).collect(Collectors.toList());
//	
//	
////	List<EntityModel<Order>> orders = orderRepository.findAll().stream().map(assembler::toModel)
////	.collect(Collectors.toList());
//
////	List<EntityModel<Employee>> employees = repository.findAll().stream()
////	.map(employee -> new EntityModel<>(employee,
////			linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
////			linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
////	.collect(Collectors.toList());
//	
//	
////	Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
//
////	return new EntityModel<>(employee, linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
////			linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
//	

	@PutMapping("/return")
	public void delete(@RequestBody RentDTO rentDTO) {
		rentEntityService.delete(rentDTO);
	}

}

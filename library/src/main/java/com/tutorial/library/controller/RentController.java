package com.tutorial.library.controller;

import java.lang.module.FindException;
import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.tutorial.library.exception.EntityNotFoundException;
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

@RestController
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
		StockDTO stockDTO_ = mapper.mapEntityToDto(stockEntityService.findById(stockDTO.getId()).orElseThrow());
		RentDTO rentDTO = new RentDTO();
		CustomerEntity entity = session.getCustomerEntity();
		rentDTO.setCustomer(mapper.mapEntityToDto(customerEntityService.findById(entity.getId()).orElseThrow()));
		rentDTO.setStock(mapper.mapEntityToDto(stockEntityService.findByLibraryAndBook(
				libraryEntityService.findById(stockDTO_.getLibrary().getId()).orElseThrow(),
				bookEntityService.findById(stockDTO_.getBook().getId()).orElseThrow())));
		rentEntityService.save(rentDTO);
		return ResponseEntity.ok(rentDTO.getId());

	}

	@GetMapping("/all")
	public CollectionModel<EntityModel<?>> all() {
		Stream<RentEntity> rentedList = rentEntityService.findAll().stream();

		List<EntityModel<?>> viewList = new ArrayList<>();
		rentedList.forEach(rentedOne -> {
			viewList.add(new EntityModel<>(rentedOne.getCustomer(),
					linkTo(methodOn(CustomerController.class).one(rentedOne.getCustomer().getId())).withSelfRel(),
					linkTo(methodOn(BookController.class).one(rentedOne.getStock().getBook().getId())).withSelfRel(),
					linkTo(methodOn(LibraryController.class).one(rentedOne.getStock().getLibrary().getId()))
							.withSelfRel()));
		});

		return new CollectionModel<>(viewList);
	}
//		List<EntityModel<CustomerEntity>> customers = rentEntityService.findAll().stream()
//				.map(rentedOne -> rentedOne.getCustomer())
//				.map(customer -> new EntityModel<>(customer,
//						linkTo(methodOn(CustomerController.class).one(customer.getId())).withSelfRel(),
//						linkTo(methodOn(CustomerController.class).all()).withRel("customers")))
//				.collect(Collectors.toList());

//		List<EntityModel<CustomerEntity>> customersWhoRented = rentedList
//				.map(rentedOne -> new EntityModel<>(customer,
//						linkTo(methodOn(CustomerController.class).one(rentedOne.getCostumer().getId())).withSelfRel(),
//						linkTo(methodOn(CustomerController.class).all()).withRel("customers")))
//				.collect(Collectors.toList());

//			viewList.add(new EntityModel<> (rentedOne.getStock().getBook(),
//					linkTo(methodOn(BookController.class).one(rentedOne.getStock().getBook().getId())).withSelfRel()));
//			
//			viewList.add(new EntityModel<> (rentedOne.getStock().getLibrary(),
//					linkTo(methodOn(LibraryController.class).one(rentedOne.getStock().getLibrary().getId())).withSelfRel()));

//		List<EntityModel<StockEntity>> rentedStocks=rentedList.map(rentedOne -> rentedOne.getStock())

//		List<CustomerEntity> customersWhoRented= new ArrayList<>();
//		
//		rentEntityService.findAll().stream().forEach(rentedOne -> customersWhoRented.add(rentedOne.getCustomer()));
//		
//		List<EntityModel<RentEntity>> customersInformations=(List<EntityModel<RentEntity>>) customersWhoRented.stream().map(customer -> new EntityModel<>(customer, 
//				linkTo(methodOn(CustomerController.class).one(customer.getId())).withSelfRel(),
//				linkTo(methodOn(CustomerController.class).all()).withRel("Informations of Customer's Who Rented")));
//		
//		return true;

//		List<EntityModel<CustomerEntity>> rentedList;
//		rentEntityService.findAll().stream().forEach(rentedOne -> {
//			rentedList.add(new EntityModel(rentedOne.getCustomer(), linkTo(methodOn(CustomerController.class).one(rentedOne.getCustomer().getId())).withSelfRel(),
//					linkTo(methodOn(CustomerController.class).all()).withRel("Customers")));

//			rentedList.add(new EntityModel(rentedOne.getStock(), linkTo(methodOn(StockController.class).one(rentedOne.getStock().getId())).withSelfRel(),
//					linkTo(methodOn(StockController.class).all()).withRel("Stocks")));

//			});

//		return new CollectionModel<>(rentedList, linkTo(methodOn(CustomerController.class).all()).withSelfRel());

//	forEach(rentedOne -> 
//		{new EntityModel<>(rentedOne.getCustomer(), linkTo(methodOn(CustomerController.class).one(rentedOne.getCustomer().getId())).withSelfRel(),
//				linkTo(methodOn(CustomerController.class).all()).withRel("Customers")).collect(Collectors.toList());});
//		
//		new EntityModel<>(rentedOne.getCustomer(), linkTo(methodOn(CustomerController.class).one(rentedOne.getCustomer().getId())).withSelfRel(),
//				linkTo(methodOn(CustomerController.class).all()).withRel("Customers")).collect(Collectors.toList());
//		
//		}stream.forEach(name->
//
//	{
//		System.out.println(name);
//		List<EntityModel<RentEntity>> rentedList = rentEntityService.findAll().stream()
//				.map(rentedOne -> new EntityModel(rentedOne,
//						linkTo(methodOn(RentController.class).one(rentedOne.getId())).withSelfRel(),
//						linkTo(methodOn(RentController.class).all()).withRel("RentedList")))
//				.collect(Collectors.toList());
//		return new CollectionModel<>(rentedList, linkTo(methodOn(RentController.class).all()).withSelfRel());

	@GetMapping("/{id}")
	EntityModel<RentEntity> one(@PathVariable Long id) {
		RentEntity rentedOne = rentEntityService.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
		return new EntityModel<RentEntity>(rentedOne, linkTo(methodOn(RentController.class).one(id)).withSelfRel(),
				linkTo(methodOn(RentController.class).all()).withRel("RentedList"));
	}

//	@GetMapping("/owned")

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

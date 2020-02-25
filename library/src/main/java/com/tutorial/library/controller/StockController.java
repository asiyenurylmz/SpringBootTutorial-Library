package com.tutorial.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.library.dto.BookDTO;
import com.tutorial.library.dto.LibraryDTO;
import com.tutorial.library.dto.StockDTO;
import com.tutorial.library.entity.StockEntity;
import com.tutorial.library.service.BookEntityService;
import com.tutorial.library.service.LibraryEntityService;
import com.tutorial.library.service.StockEntityService;
import com.tutorial.library.util.Mapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

	
	private final StockEntityService stockEntityService;
	private final LibraryEntityService libraryService;
	private final BookEntityService bookService;
	private final Mapper mapper;
	
	
	@PutMapping("/add")
	public StockEntity add(@RequestBody StockDTO stock) {
		return stockEntityService.save(stock);
	}

	@GetMapping("/list/library/{bookId}")
	public List<LibraryDTO> listLibrary(@PathVariable Long bookId) {
		return stockEntityService.listLibrary(bookId);
	}
	
	@GetMapping("/list/book/{libraryId}")
	public List<BookDTO> listBook(@PathVariable Long libraryId) {
		return stockEntityService.listBook(libraryId);
	}
	
//	@GetMapping("/update/{stockId}/{count}")
//	public StockDTO update(@PathVariable Long stockId, @PathVariable Integer count) {
//		return stockEntityService.update(stockId, count);
//	}
	
//	@GetMapping("/update/{libraryId}/{bookId}/{count}")
//	public StockEntity update(@PathVariable Long libraryId,...){
//		
//	}

	
	//http:......./stock/{libraryId}/{bookId}/15
	
	//http:......./stock/{libraryId}/{bookId}/-15
	
	//http:......./stock/{libraryId}/{bookId}/add/15
	
	//http:......./stock/{libraryId}/{bookId}/sub/15



}

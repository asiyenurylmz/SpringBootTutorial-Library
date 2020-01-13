package com.tutorial.library.controller;

import java.lang.module.FindException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.entity.StockEntity;
import com.tutorial.library.model.BookDTO;
import com.tutorial.library.model.LibraryDTO;
import com.tutorial.library.model.StockDTO;
import com.tutorial.library.service.BookEntityService;
import com.tutorial.library.service.LibraryEntityService;
import com.tutorial.library.service.StockEntityService;
import com.tutorial.library.util.Mapper;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockEntityService stockInformationEntityService;
	@Autowired
	private LibraryEntityService libraryService;
	@Autowired
	private BookEntityService bookService;

	@Autowired
	private Mapper mapper;

	@PutMapping("/add")
	public StockEntity add(@RequestBody StockEntity stock) {
		return stockInformationEntityService.save(stock);
	}




}

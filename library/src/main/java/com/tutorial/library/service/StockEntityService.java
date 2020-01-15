package com.tutorial.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.entity.StockEntity;
import com.tutorial.library.model.StockDTO;
import com.tutorial.library.repository.StockRepository;
import com.tutorial.library.util.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockEntityService {
	private final StockRepository repository;
	private final Mapper mapper;
	private final LibraryEntityService libraryEntityService;
	private final BookEntityService bookEntityService;

	public StockEntity save(StockEntity stock) {
		return repository.save(stock);
	}
	

	public List<StockEntity> findByLibrary(LibraryEntity library) {
		return repository.findByLibrary(library);
	}


	public List<StockEntity> findByLibraryAndBook(LibraryEntity library, BookEntity book) {
		return repository.findByLibraryAndBook(library, book);
	}
	
	public StockEntity saveNew(StockDTO stock) {
		StockEntity stockEntity= mapper.mapDtoToEntity(stock);
		stockEntity.setLibrary(libraryEntityService.findById(stock.getLibrary().getId()).orElseThrow());
		stockEntity.setBook(bookEntityService.findById(stock.getBook().getId()).orElseThrow());
//		stockEntity.setCount(stock.getCount());
		return repository.save(stockEntity);
	}
}

package com.tutorial.library.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.entity.StockEntity;
import com.tutorial.library.model.BookDTO;
import com.tutorial.library.model.LibraryDTO;
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

	public List<StockEntity> findByBook(BookEntity book) {
		return repository.findByBook(book);
	}

	public List<StockEntity> findByLibraryAndBook(LibraryEntity library, BookEntity book) {
		return repository.findByLibraryAndBook(library, book);
	}

	public StockEntity addNew(StockDTO stock) {
		StockEntity stockEntity = mapper.mapDtoToEntity(stock);
		stockEntity.setLibrary(libraryEntityService.findById(stock.getLibrary().getId()).orElseThrow());
		stockEntity.setBook(bookEntityService.findById(stock.getBook().getId()).orElseThrow());
		return repository.save(stockEntity);
	}

	public List<LibraryDTO> listLibrary(Long bookId) {
		List<StockEntity> stock = this.findByBook(bookEntityService.findById(bookId).orElseThrow());
		List<LibraryDTO> libraries = stock.stream().map(s -> mapper.mapEntityToDto(s.getLibrary()))
				.collect(Collectors.toList());
		return libraries;
	}

	public List<BookDTO> listBook(Long libraryId) {
		List<StockEntity> stock = this.findByLibrary(libraryEntityService.findById(libraryId).orElseThrow());
		List<BookDTO> books = stock.stream().map(s -> mapper.mapEntityToDto(s.getBook())).collect(Collectors.toList());
		return books;
	}

}

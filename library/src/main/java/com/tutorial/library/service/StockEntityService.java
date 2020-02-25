package com.tutorial.library.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tutorial.library.dto.BookDTO;
import com.tutorial.library.dto.LibraryDTO;
import com.tutorial.library.dto.StockDTO;
import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.entity.StockEntity;
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

	public StockEntity findByLibraryAndBook(LibraryEntity library, BookEntity book) {
		return repository.findByLibraryAndBook(library, book);
	}

	public Optional<StockEntity> findById(Long id) {
		return repository.findById(id);
	}

	public void rent(StockEntity stock) {
		stock.setCount(stock.getCount() + 1);
		this.save(stock);
	}

	public StockEntity save(StockDTO stock) {
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

	@Transactional
	public StockDTO update(Long stockId, Integer count) {
		StockEntity stockEntity = this.findById(stockId).orElseThrow();
		stockEntity.setCount(stockEntity.getCount() + count);
		this.save(stockEntity);
		return mapper.mapEntityToDto(stockEntity);
	}
//	

}

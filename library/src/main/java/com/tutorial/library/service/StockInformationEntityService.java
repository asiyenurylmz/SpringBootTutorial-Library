package com.tutorial.library.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.entity.StockInformationEntity;
import com.tutorial.library.repository.StockInformationRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StockInformationEntityService {

	@Autowired
	private StockInformationRepository repository;

	public StockInformationEntity save(StockInformationEntity stock) {
		return repository.save(stock);
	}

	public List<StockInformationEntity> findByLibrary(LibraryEntity library) {
		return repository.findByLibrary(library);
	}

	public List<StockInformationEntity> findByLibraryAndBook(BookEntity book, LibraryEntity library) {
		return repository.findByLibraryAndBook(library, book);
	}
}

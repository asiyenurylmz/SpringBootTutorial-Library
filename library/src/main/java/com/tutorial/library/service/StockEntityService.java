package com.tutorial.library.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.entity.StockEntity;
import com.tutorial.library.model.BookDTO;
import com.tutorial.library.model.LibraryDTO;
import com.tutorial.library.repository.LibraryRepository;
import com.tutorial.library.repository.StockRepository;

@Service
public class StockEntityService {
	@Autowired
	private StockRepository repository;
	@Autowired
	private LibraryEntityService libraryEntityService;
	@Autowired
	private BookEntityService bookEntityService;

	public StockEntity save(StockEntity stock) {
		return repository.save(stock);
	}
	

	public List<StockEntity> findByLibrary(LibraryEntity library) {
		return repository.findByLibrary(library);
	}


	public List<StockEntity> findByLibraryAndBook(LibraryEntity library, BookEntity book) {
		return repository.findByLibraryAndBook(library, book);
	}
}

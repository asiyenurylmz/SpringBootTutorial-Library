package com.tutorial.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.entity.StockInformationEntity;

@Repository
public interface StockInformationRepository extends JpaRepository<StockInformationEntity, Long> {

	List<StockInformationEntity> findByLibrary(LibraryEntity library);

	List<StockInformationEntity> findByLibraryAndBook(LibraryEntity library, BookEntity book);

	List<StockInformationEntity> findByBook(BookEntity book);
}

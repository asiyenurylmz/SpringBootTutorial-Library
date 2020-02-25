package com.tutorial.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

	
	//StockEntity findById(Long id);
	
	List<StockEntity> findByLibrary(LibraryEntity library);

	StockEntity findByLibraryAndBook(LibraryEntity library, BookEntity book);

	List<StockEntity> findByBook(BookEntity book);
	
	
//TODO:	
//	StockDTO update(StockDTO stock, Integer count);
//	@Transactional
//	@Modifying // bak
//	@Query("update Product p set p.count=p.count-:count where p.id=:id and p.count>=:count")
//	Integer updateStock(@Param("id") Long id, @Param("count") Long count);
}

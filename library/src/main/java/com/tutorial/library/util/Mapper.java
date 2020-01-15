package com.tutorial.library.util;

import java.util.List;

import javax.annotation.Priority;

import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.tutorial.library.entity.BaseEntity;
import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.entity.StockEntity;
import com.tutorial.library.model.BaseDTO;
import com.tutorial.library.model.BookDTO;
import com.tutorial.library.model.LibraryDTO;
import com.tutorial.library.model.StockDTO;

@Priority(value = 0)
@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class Mapper {
	
//	public abstract BaseDTO mapEntityToDto(BaseEntity entity);
//	
//	public abstract BaseEntity mapDtoToEntity(BaseDTO dto);
//	
//	public abstract void updateEntity(BaseDTO dto, @MappingTarget BaseEntity entity);
	
	//Book
	public abstract BookDTO mapEntityToDto(BookEntity entity);

	public abstract BookEntity mapDtoToEntity(BookDTO dto);

	public abstract void updateEntity(BookDTO dto, @MappingTarget BookEntity entity);
	
	
	//Library
	public abstract LibraryDTO mapEntityToDto(LibraryEntity entity);
	
	public abstract LibraryEntity mapDtoToEntity(LibraryDTO dto);
	
	public abstract void updateEntity(LibraryDTO dto, @MappingTarget LibraryEntity entity);
	
	//Stock	
	public abstract StockDTO mapEntityToDto(StockEntity entity);

	public abstract StockEntity mapDtoToEntity(StockDTO dto);

	public abstract void updateEntity(StockDTO dto, @MappingTarget StockEntity entity);
}

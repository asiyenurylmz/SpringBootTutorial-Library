package com.tutorial.library.util;

import java.util.List;

import javax.annotation.Priority;

import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.tutorial.library.dto.BookDTO;
import com.tutorial.library.dto.CustomerDTO;
import com.tutorial.library.dto.LibraryDTO;
import com.tutorial.library.dto.RentDTO;
import com.tutorial.library.dto.StockDTO;
import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.CustomerEntity;
import com.tutorial.library.entity.LibraryEntity;
import com.tutorial.library.entity.RentEntity;
import com.tutorial.library.entity.StockEntity;

@Priority(value = 0)
@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class Mapper {

//	public abstract BaseDTO mapEntityToDto(BaseEntity entity);
//	
//	public abstract BaseEntity mapDtoToEntity(BaseDTO dto);
//	
//	public abstract void updateEntity(BaseDTO dto, @MappingTarget BaseEntity entity);

	// Book
	public abstract BookDTO mapEntityToDto(BookEntity entity);

	public abstract BookEntity mapDtoToEntity(BookDTO dto);

	public abstract void updateEntity(BookDTO dto, @MappingTarget BookEntity entity);

	// Library
	public abstract LibraryDTO mapEntityToDto(LibraryEntity entity);

	public abstract LibraryEntity mapDtoToEntity(LibraryDTO dto);

	public abstract void updateEntity(LibraryDTO dto, @MappingTarget LibraryEntity entity);

	// Stock
	public abstract StockDTO mapEntityToDto(StockEntity entity);
	
	public abstract StockEntity mapDtoToEntity(StockDTO dto);
	
	public abstract void updateEntity(StockDTO dto, @MappingTarget StockEntity entity);
	
	public abstract List<LibraryDTO> mapEntityToDTOList(List<LibraryEntity> libraries);
	
	// Customer
	public abstract CustomerDTO mapEntityToDto(CustomerEntity entity);
	
	public abstract CustomerEntity mapDtoToEntity(CustomerDTO dto);
	
	public abstract void updateEntity(CustomerDTO dto, @MappingTarget CustomerEntity entity);
	
	// Rented
	public abstract RentDTO mapEntityToDto(RentEntity entity);

	public abstract RentEntity mapDtoToEntity(RentDTO dto);

	public abstract void updateEntity(RentDTO dto, @MappingTarget RentEntity entity);

//	public abstract List<LibraryDTO> mapEntityToDTOList(List<LibraryEntity> libraries);
}

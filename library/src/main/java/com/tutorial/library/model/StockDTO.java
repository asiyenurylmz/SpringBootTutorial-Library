package com.tutorial.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tutorial.library.entity.BookEntity;
import com.tutorial.library.entity.LibraryEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDTO extends BaseDTO{
	@JsonIgnore
	private Long id;
	private LibraryDTO library;
	private BookDTO book;
	private Integer count;
}

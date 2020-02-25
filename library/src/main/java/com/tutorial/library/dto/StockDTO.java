package com.tutorial.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDTO extends BaseDTO{
	private Long id;
	private LibraryDTO library;
	private BookDTO book;
	private Integer count;
}

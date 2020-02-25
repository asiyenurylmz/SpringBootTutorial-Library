package com.tutorial.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentDTO extends BaseDTO{

	private Long id;
	private CustomerDTO customer;
	private StockDTO stock;
//	LocalDateTime dueDate;
}

package com.tutorial.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO extends BaseDTO{
	private Long id;
	private String username;
	private String password;
	private String email;
	private Long phoneNumber;
	
}

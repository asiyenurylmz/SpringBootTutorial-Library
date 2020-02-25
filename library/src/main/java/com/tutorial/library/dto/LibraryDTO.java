package com.tutorial.library.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibraryDTO extends BaseDTO {
	private Long id;
	private String name;
	private String city;
	private String district;
	
	@JsonInclude(value = Include.NON_NULL)
	private Long latitude;
	@JsonInclude(value = Include.NON_NULL)
	private Long longitude;
}

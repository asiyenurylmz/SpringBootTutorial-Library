package com.tutorial.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO extends BaseDTO {
	private Long id;
	private String name;
	private String author;
}

package com.tutorial.library.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO {
	LocalDateTime createdAt;
	LocalDateTime updatedAt;
}

package com.tutorial.library.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.tutorial.library.entity.CustomerEntity;

import lombok.Getter;
import lombok.Setter;

@SessionScope
@Component
@Getter
@Setter
public class CustomSession {
	private CustomerEntity customerEntity;
}

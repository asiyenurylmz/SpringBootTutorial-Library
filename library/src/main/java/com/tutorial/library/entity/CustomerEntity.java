package com.tutorial.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@Table(name = "customer", uniqueConstraints = {@UniqueConstraint(columnNames = { "username", "email", "phone_number" }) })
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {
	@Id
	@SequenceGenerator(name = "customer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

//	@Column(name = "phone_number",nullable = false, length=10)
	@Column(name = "phone_number",nullable = false)
	private Long phoneNumber;

	@Column(name = "latitude")
	private Long latitude;

	@Column(name = "longitude")
	private Long longitude;

}

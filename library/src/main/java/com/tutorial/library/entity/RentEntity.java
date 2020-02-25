package com.tutorial.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "rentedList", uniqueConstraints = { @UniqueConstraint( columnNames = { "customer_id", "stock_id" } ) })
public class RentEntity extends BaseEntity{
	
	@Id
	@SequenceGenerator(name = "rentedList_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rentedList_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;

	
	@ManyToOne
	@JoinColumn(name = "stock_id", nullable = false)
	private StockEntity stock;
	
//	@DateTimeFormat
//	@Column(name = "due_date", nullable = false)
//	LocalDateTime dueDate;
//	
//	@PrePersist
//	void prePersist() {
//		dueDate = updatedAt.plusDays(30);
//	}
	
}

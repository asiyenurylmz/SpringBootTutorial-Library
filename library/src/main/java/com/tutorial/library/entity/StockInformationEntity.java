package com.tutorial.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "StockInformation")
public class StockInformationEntity extends BaseEntity {

	@Id
	@SequenceGenerator(name = "stock_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_id_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "library_id")
	private LibraryEntity library;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private BookEntity book;

	@Column(name = "stock_status")
	public int stock_status;

}
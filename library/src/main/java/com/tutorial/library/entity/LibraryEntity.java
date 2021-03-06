package com.tutorial.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "library")
public class LibraryEntity extends BaseEntity {

	@Id
	@SequenceGenerator(name = "library_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_id_seq")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String district;

	@JsonInclude(value = Include.NON_NULL)
	@Column(name = "latitude")
	private Long latitude;
	
	@JsonInclude(value = Include.NON_NULL)
	@Column(name = "longitude")
	private Long longitude;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "library_book", joinColumns = @JoinColumn(name = "library_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
//	private List<BookEntity> booksInTheLibrary;

}

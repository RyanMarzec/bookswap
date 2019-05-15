package com.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotEmpty;

@Entity(name="comment")
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(name = "text", length = 700, nullable = false)
	private String text;

	@NotEmpty
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;
	
	@NotEmpty
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
}
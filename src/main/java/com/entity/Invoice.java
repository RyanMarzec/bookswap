package com.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotEmpty;

@Entity(name="invoice")
@Table(name="invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(name = "total", length = 30, nullable = false)
	private Double totalToBePaid;
	
	@CreationTimestamp
	@Column(name = "CreatedDate", updatable=false)
	private Timestamp createdDate;

	@UpdateTimestamp
	@Column(name = "ModifiedDate")
	private Timestamp modifiedDate;
	
	@NotEmpty
	@OneToOne(fetch = FetchType.EAGER)
	private Ad ad;
	
	@NotEmpty
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private User buyer;
	
	@NotEmpty
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private User seller;
	
}

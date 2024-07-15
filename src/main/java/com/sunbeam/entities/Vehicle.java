 package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(length = 30)
	private String vname;
	
	@Enumerated(EnumType.STRING)
	private Company company;
	
	@NotBlank
	private String vnumber;
	
	@NotBlank
	private String vtype;
	
	@Column(name = "price", columnDefinition = "DECIMAL(10, 2)")
	private Double price;
	
	@ManyToOne
//	@JoinColumn(name = "customer_id")
	@JoinColumn(name = "customer_id", referencedColumnName = "uid", nullable = true)
	@Cascade(CascadeType.ALL)
	private Customer customer;
	
	@NotNull(message = "Purchase Date Must not be Blank!!")
	private LocalDate purchaseDate;
}

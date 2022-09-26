package com.practice.demo.entity;

import java.math.BigDecimal;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="cars")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carid")
	private Long car_id;
	
	@Column(name = "model_year")
	private String model_year;
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "fuel")
	private String fuel_type;
	
	@Column(name = "cost")
	private BigDecimal cost;
	
	@ManyToOne
    @JoinColumn(name = "garage")
    private Garage garage;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "car_driver", 
      joinColumns = @JoinColumn(name = "carid"), 
      inverseJoinColumns = @JoinColumn(name = "driverid"))
	private List<Driver> drivers2;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "car")
	private CarInfo carinfo;
}

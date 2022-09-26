package com.practice.demo.entity;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="garages")
@Data
public class Garage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "garageid")
	private Long garage_id;
	
	@Column(name = "spaces")
	private Long spaces;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@JsonIgnore
	 @OneToMany(mappedBy = "garage",
	            cascade = CascadeType.ALL)
	    private List<Product> cars3;
}

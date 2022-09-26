package com.practice.demo.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name="car_info")
@Data
public class CarInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carid")
	private Long car_id;
	
	@Column(name = "vin")
	private String vin;
	
	@Column(name = "lic")
	private String lic;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carid", nullable = false, unique = true)
	private Product car;
}
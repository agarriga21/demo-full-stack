package com.practice.demo.service;

import java.util.List;

import com.practice.demo.entity.Driver;
import com.practice.demo.entity.Garage;
import com.practice.demo.entity.Product;


public interface GarageService {
	
	
	public List<Garage> getAllGarages();
	
	public List<Product> getCarsInGarage(Long garageID);
	
	Garage addGarage(Garage newGarage);
	
	List<Product> parkCar(Long garageID, Long carid, Garage garage);
	
	Garage updGarage(long garageID, Garage garage);
}

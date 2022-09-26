package com.practice.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.dao.GarageRepository;
import com.practice.demo.entity.Garage;
import com.practice.demo.entity.Product;

@Service
public class GarageServiceImpl implements GarageService {
	@Autowired
	private GarageRepository gr;
	
	@Override
	 public List<Product> getCarsInGarage(Long garageID) {
		 Garage garage = null;
		 List<Product> cars = null;
		 Optional<Garage> optional = gr.findById(garageID);
	        if (optional.isPresent()) {
	        	garage = gr.findById(garageID).get();
	            cars = garage.getCars3();
	        }
		 
		 return cars;
		 
	 }

	@Override
	public List<Garage> getAllGarages() {
		return gr.findAll();
	
	}

	@Override
	public Garage addGarage(Garage newGarage) {
		return gr.save(newGarage);
		
	}

	@Override
	public List<Product> parkCar(Long garageID, Long carid, Garage garage) {
		
		//todo
		return null;
	}

	@Override
	public Garage updGarage(long garageID, Garage garage) {
		garage.setGarage_id(garageID);
        gr.save(garage);
        return garage;
	
	}
}

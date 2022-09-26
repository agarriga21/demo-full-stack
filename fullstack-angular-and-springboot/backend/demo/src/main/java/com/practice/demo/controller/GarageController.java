package com.practice.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;


import com.practice.demo.dao.GarageRepository;

import com.practice.demo.entity.Garage;
import com.practice.demo.entity.Product;

import com.practice.demo.service.GarageService;

@RestController
public class GarageController {
	private GarageService garageService;

	 
	 public GarageController(GarageService garageService) {
	        this.garageService = garageService;
	        
	    }
	@Autowired
    GarageRepository garageRespository;
	
	
    

    @GetMapping("/garagelist")
	 public ResponseEntity<List<Garage>> getAllGarages(){
       return new ResponseEntity<List<Garage>>(
               (List <Garage>) garageService.getAllGarages(),HttpStatus.OK);



}


	@GetMapping("/garagecars/{id}")
    public ResponseEntity<List<Product>> getCarsInGarage(@PathVariable("id") Long garageID) {
    	 return new ResponseEntity<List<Product>>(
                 (List<Product>) garageService.getCarsInGarage(garageID),HttpStatus.OK);


}
}

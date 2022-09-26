package com.practice.demo.controller;

import java.util.List;
import java.util.Optional;


import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.dao.DriverRepository;

import com.practice.demo.entity.Driver;
import com.practice.demo.entity.Product;
import com.practice.demo.service.DriverService;


@RestController
public class DriverController {
	private DriverService driverService;

	 
	 public DriverController(DriverService driverService) {
	        this.driverService = driverService;
	        
	    }
	@Autowired
    DriverRepository driverRespository;
	
	
    @PostMapping("/newdriver")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) throws EntityExistsException {
        Driver saveDriver = driverService.addDriver(driver);
        return new ResponseEntity<>(saveDriver, HttpStatus.CREATED);
    }

    @GetMapping("/driverlist")
	 public ResponseEntity<List<Driver>> getAllDrivers(){
       return new ResponseEntity<List<Driver>>(
               (List <Driver>) driverService.getAllDrivers(),HttpStatus.OK);



}


	@GetMapping("/driverscars/{id}")
    public ResponseEntity<List<Product>> getCarsWithDriver(@PathVariable("id") Long id) {
    	 return new ResponseEntity<List<Product>>(
                 (List<Product>) driverService.getCarsWithDriver(id),HttpStatus.OK);



}
	 @GetMapping("/driver/{id}")
	  public Optional<Driver> getGuyById(@PathVariable Long id){
		  Optional<Driver> driver=driverService.getGuyById(id);
		  return driver;
	  }
	  @PutMapping("updateDriver/{id}")
	    public ResponseEntity<Driver> updDriver(@PathVariable long id, @RequestBody Driver driver) {
	    	Driver updDriver = driverService.updDriver(id, driver);
	    	return new ResponseEntity<>(updDriver, HttpStatus.CREATED);
	    }
}
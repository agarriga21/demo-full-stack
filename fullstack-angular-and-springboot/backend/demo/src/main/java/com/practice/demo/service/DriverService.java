package com.practice.demo.service;

import java.util.List;
import java.util.Optional;

import com.practice.demo.entity.Driver;
import com.practice.demo.entity.Product;


public interface DriverService {
	Driver addDriver(Driver newDriver);

	Driver updDriver(long id, Driver driver);
	
	Driver delDriver(Long driverID);
	
	public List<Driver> getAllDrivers();
	
	public List<Product> getCarsWithDriver(Long driverID);
	
	public Optional<Driver> getGuyById(long id);
	

}

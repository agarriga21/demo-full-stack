package com.practice.demo.service;

import java.util.List;
import java.util.Optional;


import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.demo.dao.DriverRepository;

import com.practice.demo.entity.Driver;
import com.practice.demo.entity.Product;


@Service
public class DriverServiceImpl implements DriverService {
	@Autowired
	private DriverRepository dr;
	
	@Override
	public Driver addDriver(Driver newDriver) throws EntityExistsException {
        return dr.save(newDriver);
	}

	
	  @Override
	    public List<Driver> getAllDrivers() {
	        return dr.findAll();
	    }
	  
	 @Override
	    public Driver delDriver(Long id) {
	        Driver driver = null;
	        Optional<Driver> optional = dr.findById(id);
	        if (optional.isPresent()) {
	            driver = dr.findById(id).get();
	            dr.deleteById(id);
	        }
	        return driver;

}

	 @Override
	 public List<Product> getCarsWithDriver(Long driverID){
		 Driver driver = null;
		 List<Product> cars = null;
	        Optional<Driver> optional = dr.findById(driverID);
	        if (optional.isPresent()) {
	            driver = dr.findById(driverID).get();
	            cars = driver.getCars2();
	        }
	        return cars;
		
		 
	 }

	@Override
	public Optional<Driver> getGuyById(long id) {
			return dr.findById(id);
	}

	@Override
	public Driver updDriver(long id, Driver driver) {
		driver.setDriver_id(id);
        dr.save(driver);
        return driver;
	}
}
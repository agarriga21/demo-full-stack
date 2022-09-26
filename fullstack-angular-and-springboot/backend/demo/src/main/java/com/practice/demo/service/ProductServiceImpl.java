package com.practice.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.practice.demo.dao.ProductRepository;
import com.practice.demo.entity.CarInfo;
import com.practice.demo.entity.Driver;

import com.practice.demo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository pr;
	
	@Override
	public Product addProd(Product newProd) throws EntityExistsException {
        return pr.save(newProd);
	}

	
	  @Override
	    public List<Product> getAllProducts() {
	        return pr.findAll();
	    }
	  
	 @Override
	    public Product delProd(Long id) {
	        Product product = null;
	        Optional<Product> optional = pr.findById(id);
	        if (optional.isPresent()) {
	            product = pr.findById(id).get();
	            pr.deleteById(id);
	        }
	        return product;

}
	 @Override
	 public List<Driver> getDriversOfCar(Long carID){
		 Product car = null;
		 List<Driver> drivers = null;
	        Optional<Product> optional = pr.findById(carID);
	        if (optional.isPresent()) {
	            car = pr.findById(carID).get();
	            drivers = car.getDrivers2();
	        }
	        return drivers;
		 
	 }

	@Override
	public CarInfo getInfo(Long carID) {
		 Product car = null;
		 CarInfo carinfo = null;
	        Optional<Product> optional = pr.findById(carID);
	        if (optional.isPresent()) {
	            car = pr.findById(carID).get();
	            carinfo = car.getCarinfo();
	        }
	        return carinfo;
		 

	}

	@Override
	public Optional<Product> getCarById(long id) {
		return pr.findById(id);
	
	}

	@Override
	public Product updProd(long id, Product car) {
		car.setCar_id(id);
        pr.save(car);
        return car;
		
	}
	 
}

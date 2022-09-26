package com.practice.demo.service;

import java.util.List;
import java.util.Optional;


import com.practice.demo.entity.CarInfo;
import com.practice.demo.entity.Driver;

import com.practice.demo.entity.Product;

public interface ProductService {
	Product addProd(Product newProd);
	
	public Optional<Product> getCarById(long id);
	
	
	Product updProd(long id, Product car);
	
	Product delProd(Long prodID);
	
	public List<Product> getAllProducts();
	
	public List<Driver> getDriversOfCar(Long carID);
	
	public CarInfo getInfo(Long carID);
}

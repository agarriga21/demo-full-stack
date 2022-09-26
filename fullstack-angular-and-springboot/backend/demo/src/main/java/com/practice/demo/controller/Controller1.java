package com.practice.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.dao.ProductRepository;

import com.practice.demo.entity.Driver;
import com.practice.demo.entity.Product;

import com.practice.demo.service.ProductService;

@RestController
public class Controller1 {
	private ProductService productService;
	
	 public Controller1(ProductService productService) {
	        this.productService = productService;
	        
	    }

	@Autowired
    ProductRepository productRespository;
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";}
		
	@RequestMapping(path = "/test")
	public String test() {
		return "test.html";}
		
	@GetMapping("/prods")
    public List<Product> index(){
        return productRespository.findAll();
    }
	
	@GetMapping("/prodlist")
	 public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(
                (List <Product>) productService.getAllProducts(),HttpStatus.OK);
	}
	
	 @GetMapping("/car/{id}")
	  public Optional<Product> getEmpId2(@PathVariable Integer id){
		  Optional<Product> emp=productService.getCarById(id);
		  return emp;
	  }
	 
	@DeleteMapping("/proddel/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
    ResponseEntity<Product> responseEntity;
    Product deletedProduct = productService.delProd(id);
    responseEntity = new ResponseEntity<Product>(deletedProduct, HttpStatus.OK);
    return responseEntity;
}
    @PostMapping("/prodadd")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws EntityExistsException {
        Product saveProduct = productService.addProd(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }
	
    @GetMapping("/cardrivers/{id}")
    public ResponseEntity<List<Driver>> getDriversOfCar(@PathVariable("id") Long id) {
    	 return new ResponseEntity<List<Driver>>(
                 (List<Driver>) productService.getDriversOfCar(id),HttpStatus.OK);
    }
   
    @PutMapping("updateCar/{id}")
    public ResponseEntity<Product> updProd(@PathVariable long id, @RequestBody Product car) {
    	Product updProduct = productService.updProd(id, car);
    	return new ResponseEntity<>(updProduct, HttpStatus.CREATED);
    }
}


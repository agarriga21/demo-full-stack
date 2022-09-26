package com.practice.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practice.demo.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}

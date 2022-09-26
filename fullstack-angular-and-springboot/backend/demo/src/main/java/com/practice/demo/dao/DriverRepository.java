package com.practice.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.demo.entity.Driver;



public interface DriverRepository extends JpaRepository<Driver, Long>{

}

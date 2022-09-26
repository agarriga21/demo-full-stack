package com.practice.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.practice.demo.entity.Garage;



public interface GarageRepository extends JpaRepository<Garage, Long>{

}
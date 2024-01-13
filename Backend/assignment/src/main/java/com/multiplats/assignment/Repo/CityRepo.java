package com.multiplats.assignment.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplats.assignment.Model.City;

public interface CityRepo extends JpaRepository<City,Long> {
    
} 

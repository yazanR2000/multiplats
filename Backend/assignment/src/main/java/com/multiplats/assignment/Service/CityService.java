package com.multiplats.assignment.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.multiplats.assignment.Model.City;
import com.multiplats.assignment.Repo.CityRepo;

@Service
public class CityService {
    private final CityRepo cityRepo;


    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }


    public List<City> findAllCities() {
        return cityRepo.findAll();
    }

    public City save(City city){
        return cityRepo.save(city);
    }
}

package com.multiplats.assignment.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiplats.assignment.Model.School;

public interface SchoolRepo extends JpaRepository<School,Long> {
    

    @Query("SELECT s from School as s where s.city.cityId=:cityId")
    List<School> findSchoolsByCityId(Long cityId);
} 

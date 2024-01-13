package com.multiplats.assignment.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.multiplats.assignment.Model.School;
import com.multiplats.assignment.Repo.SchoolRepo;

@Service
public class SchoolService {
    private final SchoolRepo schoolRepo;

    public SchoolService(SchoolRepo schoolRepo) {
        this.schoolRepo = schoolRepo;
    }

    public List<School> findSchoolsByCityId(Long cityId){
        return schoolRepo.findSchoolsByCityId(cityId);
    }

     public School save(School school){
        return schoolRepo.save(school);
    }
}

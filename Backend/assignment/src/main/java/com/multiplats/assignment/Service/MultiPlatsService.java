package com.multiplats.assignment.Service;

import org.springframework.stereotype.Service;

import com.multiplats.assignment.DTO.MultiPlatsDTO;
import com.multiplats.assignment.Model.City;
import com.multiplats.assignment.Model.Grade;
import com.multiplats.assignment.Model.School;

@Service
public class MultiPlatsService {
    private final GradeService gradeService;
    private final CityService cityService;
    private final SchoolService schoolService;

    public MultiPlatsService(GradeService gradeService, CityService cityService, SchoolService schoolService) {
        this.gradeService = gradeService;
        this.cityService = cityService;
        this.schoolService = schoolService;
    }

    public void saveNewMultiPlats(MultiPlatsDTO multiPlatsDTO){
        City city = cityService.save(multiPlatsDTO.getCity());
        School school = multiPlatsDTO.getSchool();
        school.setCity(city);
        school = schoolService.save(school);
        Grade grade = multiPlatsDTO.getGrade();
        grade.setSchool(school);
        grade = gradeService.save(grade);
    }
}

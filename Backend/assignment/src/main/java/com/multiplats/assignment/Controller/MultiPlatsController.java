package com.multiplats.assignment.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.multiplats.assignment.DTO.MultiPlatsDTO;
import com.multiplats.assignment.Model.City;
import com.multiplats.assignment.Model.Grade;
import com.multiplats.assignment.Model.School;
import com.multiplats.assignment.Model.Students;
import com.multiplats.assignment.Service.CityService;
import com.multiplats.assignment.Service.GradeService;
import com.multiplats.assignment.Service.MultiPlatsService;
import com.multiplats.assignment.Service.SchoolService;
import com.multiplats.assignment.Service.StudentsService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/multiplats")
@CrossOrigin("*")
public class MultiPlatsController {
    private final CityService cityService;
    private final SchoolService schoolService;
    private final GradeService gradeService;
    private final StudentsService studentsService;
    private final MultiPlatsService multiPlatsService;


    public MultiPlatsController(CityService cityService, SchoolService schoolService, GradeService gradeService, StudentsService studentsService, MultiPlatsService multiPlatsService) {
        this.cityService = cityService;
        this.schoolService = schoolService;
        this.gradeService = gradeService;
        this.studentsService = studentsService;
        this.multiPlatsService = multiPlatsService;
    }
    

    @GetMapping("/cities")
    public ResponseEntity<?> findAllCities() {
        try{
            List<City> cities = cityService.findAllCities();
            return new ResponseEntity<>(cities,HttpStatus.OK);
        }catch(Exception err){
            return new ResponseEntity<>("OPPS!",HttpStatus.BAD_REQUEST);

        } 
    }
    @GetMapping("/schools/{cityId}")
    public ResponseEntity<?> findAllSchoolsByCityId(@PathVariable Long cityId) {
        try{
            List<School> schools = schoolService.findSchoolsByCityId(cityId);
            return new ResponseEntity<>(schools,HttpStatus.OK);
        }catch(Exception err){
            return new ResponseEntity<>("OPPS!",HttpStatus.BAD_REQUEST);

        } 
    }
    @GetMapping("/grades/{schoolId}")
    public ResponseEntity<?> findAllGradesBySchoolId(@PathVariable String schoolId) {
        try{
            List<Grade> grades = gradeService.findGradesBySchoolId(Long.valueOf(schoolId));
            return new ResponseEntity<>(grades,HttpStatus.OK);
        }catch(Exception err){
            return new ResponseEntity<>("OPPS!",HttpStatus.BAD_REQUEST);

        } 
    }
    @GetMapping("/students/{gradeId}")
    public ResponseEntity<?> findAllStudentsByGradeId(@PathVariable String gradeId) {
        try{
            List<Students> students = studentsService.findAllStudentsByGradeId(Long.valueOf(gradeId));
            return new ResponseEntity<>(students,HttpStatus.OK);
        }catch(Exception err){
            return new ResponseEntity<>("OPPS!",HttpStatus.BAD_REQUEST);

        } 
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveNewMultiPlats(@RequestBody MultiPlatsDTO multiPlatsDTO) {
        try{
            multiPlatsService.saveNewMultiPlats(multiPlatsDTO);
            return new ResponseEntity<>(multiPlatsDTO,HttpStatus.OK);
        }catch(Exception err){
            return new ResponseEntity<>("OPPS!",HttpStatus.BAD_REQUEST);

        } 
    }

    @PostMapping("/students/save")
    public ResponseEntity<?> saveStudents(@RequestBody List<Students> students) {
        try{
            List<Students> stds =  studentsService.saveStudents(students);
            return new ResponseEntity<>(stds,HttpStatus.OK);
        }catch(Exception err){
            return new ResponseEntity<>("OPPS!",HttpStatus.BAD_REQUEST);

        } 
    }
}

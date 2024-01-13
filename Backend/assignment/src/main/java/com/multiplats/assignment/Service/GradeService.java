package com.multiplats.assignment.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.multiplats.assignment.Model.Grade;
import com.multiplats.assignment.Repo.GradeRepo;
@Service
public class GradeService {
    private final GradeRepo gradeRepo;

    public GradeService(GradeRepo gradeRepo) {
        this.gradeRepo = gradeRepo;
    }

    public List<Grade> findGradesBySchoolId(Long schoolId){
        return gradeRepo.findGradesBySchoolId(schoolId);
    }

    public Grade save(Grade grade){
        return gradeRepo.save(grade);
    } 
}

package com.multiplats.assignment.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiplats.assignment.Model.Grade;

public interface GradeRepo extends JpaRepository<Grade,Long> {
    @Query("SELECT g from Grade as g where g.school.schoolId=:schoolId")
    List<Grade> findGradesBySchoolId(Long schoolId);
} 

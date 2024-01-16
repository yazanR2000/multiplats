package com.multiplats.assignment.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiplats.assignment.Model.Students;

public interface StudentsRepo extends JpaRepository<Students,Long> {
    @Query("SELECT n from Students as n where n.grade.gradeId=:gradeId")
    List<Students> findStudentsByGradeId(Long gradeId);
} 

package com.multiplats.assignment.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.multiplats.assignment.Model.Students;
import com.multiplats.assignment.Repo.StudentsRepo;

@Service
public class StudentsService {
    private final StudentsRepo studentsRepo;


    public StudentsService(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    public List<Students> findAllStudentsByGradeId(Long gradeId) {
        return studentsRepo.findStudentsByGradeId(gradeId);
    }

    public List<Students> saveStudents(List<Students> students){
        return studentsRepo.saveAll(students);
    }
}

package com.multiplats.assignment.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    @Column(nullable = false)
    private String gradeName;

    @Column(nullable = false)
    private Integer numberOfStudents;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "school",referencedColumnName = "schoolId", nullable = false)
    private School school;
}

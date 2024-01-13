package com.multiplats.assignment.DTO;

import com.multiplats.assignment.Model.City;
import com.multiplats.assignment.Model.Grade;
import com.multiplats.assignment.Model.School;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultiPlatsDTO {
    private City city;
    private School school;
    private Grade grade;
}

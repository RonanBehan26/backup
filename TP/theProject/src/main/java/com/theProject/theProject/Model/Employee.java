package com.theProject.theProject.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long employeeId;
    private  String employeeFirstName;
    private  String employeeLastName;

    private  String employeeAddress;

    private  String employeePhoneNumber;

    private  String salaryPA;

    private  String b2b;

    private String team;

    private Long departmentId;

}

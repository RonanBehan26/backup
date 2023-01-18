package com.theProject.theProject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //works with JPA to save the data in the DB
@Data //getters and setters, and all methods added from Lombok
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

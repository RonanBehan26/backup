package com.theProject.theProject.ValueObjects;

import com.theProject.theProject.Model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {

    private Employee employee;
    private Department department;
}

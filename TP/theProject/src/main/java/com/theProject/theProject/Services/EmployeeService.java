package com.theProject.theProject.Services;

import com.theProject.theProject.Entities.EmployeeEntity;
import com.theProject.theProject.Model.Employee;
import com.theProject.theProject.ValueObjects.ResponseTemplateVO;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);

    ResponseTemplateVO getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}

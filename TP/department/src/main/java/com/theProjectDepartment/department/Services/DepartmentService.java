package com.theProjectDepartment.department.Services;

import com.theProjectDepartment.department.Model.Department;

import java.util.List;

public interface DepartmentService {

    boolean deleteDepartmentById(Long id);

    Department getDepartmentById(Long id);

    List<Department> getAllDepartments();

    Department createDepartment(Department department);

    Department updateDepartmentById(Long id, Department department);
}

package com.theProjectDepartment.department.ServicesImpl;

import com.theProjectDepartment.department.Entities.DepartmentEntity;
import com.theProjectDepartment.department.Model.Department;
import com.theProjectDepartment.department.Repositories.DepartmentRepository;
import com.theProjectDepartment.department.Services.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
        departmentRepository.delete(departmentEntity);
        return true;
    }

    @Override
    public Department getDepartmentById(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
        Department department = new Department();
        BeanUtils.copyProperties(departmentEntity,department);
        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();

        List<Department> departmentList = departmentEntities.stream()
                .map(dep -> new Department(
                        dep.getDepartmentId(),
                        dep.getDepartmentName(),
                        dep.getHeadOfDepartment()))
                .collect(Collectors.toList());

        return departmentList;
    }

    @Override
    public Department createDepartment(Department department) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        BeanUtils.copyProperties(department, departmentEntity);
        departmentRepository.save(departmentEntity);
        return department;
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();

        departmentEntity.setDepartmentName(department.getDepartmentName());
        departmentEntity.setHeadOfDepartment(department.getHeadOfDepartment());

        departmentRepository.save(departmentEntity);
        return department;
    }
}


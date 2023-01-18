package com.theProject.theProject.ServicesImpl;

import com.theProject.theProject.Entities.EmployeeEntity;
import com.theProject.theProject.Model.Employee;
import com.theProject.theProject.Repositories.EmployeeRepository;
import com.theProject.theProject.Services.EmployeeService;
import com.theProject.theProject.ValueObjects.Department;
import com.theProject.theProject.ValueObjects.ResponseTemplateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();

        List<Employee> employeeList = employees.stream()
                .map(emp -> new Employee(emp.getEmployeeId(), emp.getEmployeeFirstName(),
                        emp.getEmployeeLastName(), emp.getEmployeeAddress(),
                        emp.getEmployeePhoneNumber(), emp.getSalaryPA(),
                        emp.getTeam(), emp.getB2b(), emp.getDepartmentId()
                )).collect(Collectors.toList());

        return employeeList;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);
        return true;
    }

    //was "http://localhost:9002/api/v1/department/"
    //was able to change to "http://DEPARTMENT-SERVICE/api/v1/department/"
    //as the service is connected to the service registry, you set service name in the .yml
    @Override
    public ResponseTemplateVO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/v1/department/"
                        + employeeEntity.getDepartmentId(), Department.class);

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);

        vo.setEmployee(employee);
        vo.setDepartment(department);
        return vo;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        employeeEntity.setEmployeeFirstName(employee.getEmployeeFirstName());
        employeeEntity.setEmployeeLastName(employeeEntity.getEmployeeLastName());
        employeeEntity.setEmployeeAddress(employee.getEmployeeAddress());
        employeeEntity.setEmployeePhoneNumber(employee.getEmployeePhoneNumber());
        employeeEntity.setB2b(employeeEntity.getB2b());
        employeeEntity.setSalaryPA(employee.getSalaryPA());
        employeeEntity.setTeam(employeeEntity.getTeam());
        employeeEntity.setDepartmentId(employee.getDepartmentId());

        employeeRepository.save(employeeEntity);

        return employee;
    }
}

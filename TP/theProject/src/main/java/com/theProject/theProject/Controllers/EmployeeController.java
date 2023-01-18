package com.theProject.theProject.Controllers;

import com.theProject.theProject.Model.Employee;
import com.theProject.theProject.Repositories.EmployeeRepository;
import com.theProject.theProject.Services.EmployeeService;
import com.theProject.theProject.ValueObjects.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    public EmployeeController(EmployeeService employeeService,
//                              EmployeeRepository employeeRepository) {
//        this.employeeService = employeeService;
//    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){

        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable Long id){
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);

        Map<String, Boolean> deletedMap = new HashMap();
        deletedMap.put("deleted", deleted);
        return ResponseEntity.ok(deletedMap);
    }

    @GetMapping("/employee/{id}")
    public ResponseTemplateVO getEmployeeByIdWithDepartmentId(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id,
                                                       @RequestBody Employee employee){
        employee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(employee);
    }

//    @PostMapping("/employee")
//    public Employee createEmployee(@RequestBody Employee employee){
//        return employeeService.createEmployee(employee);
//    }
//
//    @GetMapping("/employee")
//    public List<Employee> getAllEmployees(){
//        return employeeService.getAllEmployees();
//    }
//
//    @DeleteMapping("/employee")
//    public ResponseEntity<Map<String, Boolean>> deletedEmployeeById(@PathVariable Long id){
//        boolean deleted = false;
//        deleted = employeeService.deleteEmployee(id);
//
//        Map<String, Boolean> deletedMap = new HashMap<>();
//        deletedMap.put("deleted", deleted);
//        return ResponseEntity.ok(deletedMap);
//    }
//
//    @GetMapping("/employee/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@RequestBody Long id){
//        Employee employee = null;
//        employee = employeeService.getEmployeeById(id);
//        return ResponseEntity.ok(employee);
//    }
//
//    @PutMapping("/employee/{id}")
//    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id,
//                                                       @RequestBody Employee employee){
//        employee = employeeService.updateEmployee(id, employee);
//        return ResponseEntity.ok(employee);
//    }

}


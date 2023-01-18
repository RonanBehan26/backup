package com.theProjectDepartment.department.Controllers;

import com.theProjectDepartment.department.Model.Department;
import com.theProjectDepartment.department.Services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/department")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        Department department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/department/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDepartmentById(@PathVariable Long id){
        boolean deleted = false;
        deleted = departmentService.deleteDepartmentById(id);

        Map<String, Boolean> deletedMap = new HashMap<>();
        deletedMap.put("deleted", deleted);
        return ResponseEntity.ok(deletedMap);
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable Long id,
                                                           @RequestBody Department department){
        department = departmentService.updateDepartmentById(id, department);
        return ResponseEntity.ok(department);
    }

}

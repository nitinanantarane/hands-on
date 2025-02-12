package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> get() {
        return departmentService.get();
    }

    @PostMapping
    public Department save(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department get(@PathVariable("id") Long id) {
        return departmentService.get(id);
    }

    @PutMapping
    public Department update(@RequestBody Department department) {
        return departmentService.update(department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        departmentService.delete(id);
        return ResponseEntity.ok().build();
    }
}

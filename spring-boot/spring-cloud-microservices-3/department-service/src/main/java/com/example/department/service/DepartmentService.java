package com.example.department.service;

import com.example.department.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> get();
    Department save(Department department);
    Department get(Long id);
    Department update (Department department);
    void delete (Long id);
}

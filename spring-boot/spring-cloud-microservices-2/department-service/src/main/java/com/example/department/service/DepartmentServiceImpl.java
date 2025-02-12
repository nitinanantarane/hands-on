package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> get() {
        return departmentRepository.findAll ();
    }

    @Override
    public Department save(Department department) {
        log.info("saving new department");
        return departmentRepository.save (department);
    }

    @Override
    public Department get(Long id) {
        log.info("Returning department {}", id);
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department update (Department department) {
        return departmentRepository.save (department);
    }

    @Override
    public void delete (Long id) {
        departmentRepository.deleteById (id);
    }
}

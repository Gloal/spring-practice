package com.gigi.demo.service;

import java.util.List;

import com.gigi.demo.entity.Department;
import com.gigi.demo.error.DepartmentNotFoundException;

public interface DepartmentService {

    List<Department> getAllDepartments();
    Department getDepartmentById(Long id) throws DepartmentNotFoundException;
    Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException;
    Department saveDepartment(Department department);
    Department updateDepartment(Department department, Long id);
    void deleteDepartment(Long id);

}
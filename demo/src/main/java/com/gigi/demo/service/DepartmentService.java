package com.gigi.demo.service;

import java.util.List;

import com.gigi.demo.entity.Department;

public interface DepartmentService {

    List<Department> getAllDepartments();
    Department getDepartment(Long id);
    Department getDepartmentByName(String departmentName);
    Department saveDepartment(Department department);
    Department updateDepartment(Department department, Long id);
    void deleteDepartment(Long id);

}
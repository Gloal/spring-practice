package com.gigi.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gigi.demo.entity.Department;
import com.gigi.demo.service.DepartmentService;

import javax.validation.Valid;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private final Logger LOGGER = LogManager.getLogger(DepartmentController.class);

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("departments/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping("departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }

    @PostMapping("/departments")
    public  Department saveNewDepartment (@Valid @RequestBody Department department) { 
        LOGGER.info("Inside saveDepartment of DepartmentController");             
        return departmentService.saveDepartment(department);
    }

    @PutMapping("departments/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {  
        return departmentService.updateDepartment(department, id);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        LOGGER.info("Inside deleteDepartment of DepartmentController");      
         departmentService.deleteDepartment(id);
         return "department deleted "+id;
    }
}

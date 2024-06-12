package com.gigi.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gigi.demo.entity.Department;
import com.gigi.demo.error.DepartmentNotFoundException;
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

    //private final Logger LOGGER = LogManager.getLogger(DepartmentController.class);
    private static Logger logger;
        static {
            try {   
                   // you need to do something like below instaed of Logger.getLogger(....);
                    logger = LogManager.getLogger(DepartmentController .class); 
              } catch (Throwable th) {
                    throw new UnsupportedOperationException("Cannot load the log property file", th);
            }
        }

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("departments/{id}")
    public Department getDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) throws DepartmentNotFoundException{
        return departmentService.getDepartmentByName(departmentName);
    }

    @PostMapping("/departments")
    public  Department saveNewDepartment (@Valid @RequestBody Department department) { 
        logger.info("Inside saveDepartment of DepartmentController");             
        return departmentService.saveDepartment(department);
    }

    @PutMapping("departments/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {  
        return departmentService.updateDepartment(department, id);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        logger.info("Inside deleteDepartment of DepartmentController");      
         departmentService.deleteDepartment(id);
         return "department deleted "+id;
    }
}

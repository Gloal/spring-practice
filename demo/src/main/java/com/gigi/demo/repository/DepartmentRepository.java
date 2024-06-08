package com.gigi.demo.repository;

import org.springframework.stereotype.Repository;

import com.gigi.demo.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    //create a custom seatch using spring repository naming convention
    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departmentName);

}


package com.gigi.demo.repository;

import org.springframework.stereotype.Repository;

import com.gigi.demo.entity.Department;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    //create a custom seatch using spring repository naming convention
    public Department findByDepartmentName(String departmentName);

    public Optional<Department> findByDepartmentNameIgnoreCase(String departmentName);

}


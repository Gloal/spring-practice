package com.gigi.demo.service;

import java.io.EOFException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigi.demo.repository.DepartmentRepository;
import com.gigi.demo.entity.Department;
import com.gigi.demo.error.DepartmentNotFoundException;

 
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);

        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }
        return department.get();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department newDepartment, Long id) {

        Department oldDedepartment = departmentRepository.findById(id).get();
        
        //if the value is supplied then set the new value otherwise do nothing
        if(Objects.nonNull(newDepartment.getDepartmentName()) && 
        !"".equalsIgnoreCase(newDepartment.getDepartmentName())){
            oldDedepartment.setDepartmentName(newDepartment.getDepartmentName());
        }

        if(Objects.nonNull(newDepartment.getDepartmentAddress()) && 
        !"".equalsIgnoreCase(newDepartment.getDepartmentAddress())){
            oldDedepartment.setDepartmentAddress(newDepartment.getDepartmentAddress());
        }        
        
        if(Objects.nonNull(newDepartment.getDepartmentCode()) && 
        !"".equalsIgnoreCase(newDepartment.getDepartmentCode())){
            oldDedepartment.setDepartmentCode(newDepartment.getDepartmentCode());
        }

        return departmentRepository.save(oldDedepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
         departmentRepository.deleteById(id);
    }

    @Override
    public Department getDepartmentByName(String departmentName) throws DepartmentNotFoundException{
        Optional<Department> department = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException();
        }

        return department.get();
    }

}

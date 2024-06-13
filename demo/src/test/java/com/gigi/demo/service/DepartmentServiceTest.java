package com.gigi.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gigi.demo.entity.Department;
import com.gigi.demo.error.DepartmentNotFoundException;
import com.gigi.demo.repository.DepartmentRepository;


@ExtendWith(MockitoExtension.class) //using @SpringBootTest interferes with code as it provides entire springboot context
public class DepartmentServiceTest {

    @InjectMocks
    DepartmentServiceImpl departmentService;

    @Mock
    private DepartmentRepository departmentRepository; 

    private Department department1;
    private Department department2;

   @BeforeEach
    void setUp() {
        department1 = Department.builder()
                                    .departmentName("Info Tech")
                                    .departmentCode("IT-09")
                                    .departmentAddress("Canada")
                                    .departmentId(1L)
                                    .build();

        department2 = Department.builder()
                                    .departmentName("Human Resources")
                                    .departmentCode("HR-01")
                                    .departmentAddress("USA")
                                    .departmentId(2L)
                                    .build();
    } 

    @Test
    void testDeleteDepartment() {

    }

    @Test
    void testGetAllDepartments() {

    }

    @Test
    @DisplayName("Get Department based on Valid Department Id")
    void returnsDepartmentWhenDepartmentIdIsValid() throws DepartmentNotFoundException{
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department1));
        
        Department department = departmentService.getDepartmentById(1L);
        System.out.println(department);
        
        assertEquals("Info Tech", department.getDepartmentName());
        verify(departmentRepository, times(1)).findById(1L);
    }

    @Test
    void returnsNoDepartmentFoundExceptionWhenIdIsInvalid() throws DepartmentNotFoundException {
        when(departmentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(DepartmentNotFoundException.class, () -> {
             departmentService.getDepartmentById(1L);

        });
        verify(departmentRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveDepartment() {

    }

    @Test
    void testUpdateDepartment() {

    }
}

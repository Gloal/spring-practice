package com.gigi.demo.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.gigi.demo.error.DepartmentNotFoundException;
import com.gigi.demo.error.RestResponseEntityExceptionHandler;
import com.gigi.demo.entity.Department;
import com.gigi.demo.service.DepartmentService;

@TestConfiguration
//@ExtendWith(SpringExtension.class) - Not needed
@SpringBootTest
public class DepartmentControllerIntergrationTest {

    @MockBean
    DepartmentService departmentService;

    @Autowired
    DepartmentController departmentController;

    private MockMvc mockMvc;

    @BeforeEach
        void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(departmentController)
                        .setControllerAdvice(new RestResponseEntityExceptionHandler())
                        .build();
    }


    @Test
    void testDeleteDepartment() {

    }

    @Test
    void testGetAllDepartments() {

    }

    @Test
    void returnsDepartmentWhenIdIsValid() throws Exception{
        when(departmentService.getDepartmentById(1L)).thenReturn(
            new Department(1L,"Info Tech", "Canada", "IT-09"));

            mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get DepartmentNotFoundException when Invalid Long Id")
    void returnsDepartmentNotFoundExceptionWhenIdIsInvalid() throws Exception{
        when(departmentService.getDepartmentById(2L)).thenThrow(
            new DepartmentNotFoundException("Department not found"));

            mockMvc.perform(get("/departments/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    void testGetDepartmentByName() {

    }

    @Test
    void testSaveNewDepartment() {
        

    }

    @Test
    void testUpdateDepartment() {

    }
}

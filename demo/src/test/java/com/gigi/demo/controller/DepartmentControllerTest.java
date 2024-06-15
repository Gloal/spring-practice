package com.gigi.demo.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.gigi.demo.error.DepartmentNotFoundException;
import com.gigi.demo.entity.Department;
import com.gigi.demo.service.DepartmentService;

@WebMvcTest
public class DepartmentControllerTest {

    @MockBean
    DepartmentService departmentService;

    @Autowired
    DepartmentController departmentController;

    @Autowired
    private MockMvc mockMvc;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("Accounting")
                .departmentCode("ACC-01")
                .departmentAddress("London")
                .departmentId(1L)
                .build();
    }

    @Test
    void testDeleteDepartment() {

    }

    @Test
    void testGetAllDepartments() {

    }

    @Test
    void returnsDepartmentWhenIdIsValid() throws Exception {
        when(departmentService.getDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }

    @Test
    @DisplayName("Get DepartmentNotFoundException when Invalid Long Id")
    void returnsDepartmentNotFoundExceptionWhenIdIsInvalid() throws Exception {
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
    void testSaveNewDepartment() throws Exception {

        Department inputDepartment = Department.builder()
                .departmentName("Accounting")
                .departmentCode("ACC-01")
                .departmentAddress("London")
                .build();

        when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType("application/json")
                .content(
                        "{ \"departmentName\": \"Accounting\", \"departmentAddress\": \"London\", \"departmentCode\": \"ACC-01\" }"))
                .andExpect(status().isOk());

        /*
         * mockMvc.perform(post("/departments")
         * .contentType(MediaType.APPLICATION_JSON)
         * .content("{\n" +
         * "\t\"departmentName\":\"Accounting\",\n" +
         * "\t\"departmentAddress\":\"London\",\n" +
         * "\t\"departmentCode\":\"ACC-01\"\n" +
         * "}"))
         * .andExpect(status().isOk());
         */

    }

    @Test
    void testUpdateDepartment() {

    }
}

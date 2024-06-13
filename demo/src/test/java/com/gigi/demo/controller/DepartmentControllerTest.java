package com.gigi.demo.controller;

import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.gigi.demo.error.DepartmentNotFoundException;


import com.gigi.demo.entity.Department;
import com.gigi.demo.service.DepartmentService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DepartmentControllerTest {

    @MockBean
    DepartmentService departmentService;

    @Autowired
    DepartmentController departmentController;

    private MockMvc mockMvc;

    @BeforeEach
        void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
    }


    @Test
    void testDeleteDepartment() {

    }

    @Test
    void testGetAllDepartments() {

    }

    @Test
    void testGetDepartmentById() throws DepartmentNotFoundException{
        when(departmentService.getDepartmentById(1L)).thenReturn(
            new Department(1L,"Info Tech", "Canada", "IT-09"));

            mockMvc.perform(get("/departments/1")).andExpect(status().isOK());
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

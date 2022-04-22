package com.corso.java.esercitazione.controller;

import com.corso.java.esercitazione.domain.Employee;
import com.corso.java.esercitazione.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    private Employee employee;
    private List<Employee> employeeList;

    @BeforeEach
    void setup(){
        employee = new Employee("12345", "ciro malafronte", "scansafatiche");
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

    }

    @AfterEach
    void turnDown(){
        employee = null;
    }

    @Test
    public void GetMappingOfAllProduct() throws Exception {
        when(employeeService.getAll()).thenReturn(employeeList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employee.toString()))
                .andDo(MockMvcResultHandlers.print());
        verify(employeeService).getAll();
        verify(employeeService, times(1)).getAll();
    }


    @Test
    public void GetMappingOfProductShouldReturnRespectiveProduct() throws Exception {
        when(employeeService.getById(any())).thenReturn(employee);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/{id}", employee.getId()))
                .andDo(MockMvcResultHandlers.print());
        verify(employeeService, times(1)).getById(any());
    }

    @Test
    public void PostMappingOfProduct() throws Exception {
        when(employeeService.addEmployee(any())).thenReturn(employee);
        mockMvc.perform(
                post("/api/v2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employee.toString())
        ).andExpect(status().isCreated());
        verify(employeeService, times(1)).addEmployee(any());
    }

    @Test
    public void DeleteMappingUrlAndIdThenShouldReturnDeletedProduct() throws Exception {
        when(employeeService.deleteEmployeeById(any())).thenReturn(employee);
        mockMvc.perform(delete("/api/v2/{id}", employee.getId()))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}

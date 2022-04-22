package com.corso.java.esercitazione.repository;

import com.corso.java.esercitazione.domain.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    Employee employee;

    @BeforeEach
    void setup(){
        employee = new Employee("1234", "ciro malafronte", "cameriere");
    }

    @AfterEach
    void tearDown(){
        employee = null;
        employeeRepository.deleteAll();
    }

    @Test
    void givenEmployeeToAddShouldReturnAddedemployee(){
        employeeRepository.save(employee);
        Employee e = employeeRepository.findById(employee.getId()).orElse(null);
        assertEquals(employee.getId(), e.getId());
    }

    @Test
    void givenGetAllShouldReturnAllAddedEmployees(){
        employeeRepository.save(employee);
        List<Employee> employees = employeeRepository.findAll();
        assertEquals(employee.getId(), employees.get(0).getId());
    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheemployees() {
        employeeRepository.save(employee);
        employeeRepository.deleteById(employee.getId());

        Employee e = employeeRepository.findById(employee.getId()).orElse(null);

        assertNull(e);
    }

}

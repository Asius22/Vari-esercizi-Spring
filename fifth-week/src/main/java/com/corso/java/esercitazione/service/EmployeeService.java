package com.corso.java.esercitazione.service;

import com.corso.java.esercitazione.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    Employee deleteEmployeeById(String id);
    Employee getById(String id);
    List<Employee> getAll();

}

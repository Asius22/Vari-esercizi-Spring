package com.corso.java.esercitazione.service;

import com.corso.java.esercitazione.domain.Employee;
import com.corso.java.esercitazione.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee deleteEmployeeById(String id) {
        Employee e = employeeRepository.findById(id).orElse(null);

        if (e != null)
            employeeRepository.deleteById(id);

        return e;
    }

    @Override
    public Employee getById(String id) {
        return employeeRepository.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}

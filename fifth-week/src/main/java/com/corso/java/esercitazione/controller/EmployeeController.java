package com.corso.java.esercitazione.controller;

import com.corso.java.esercitazione.domain.Employee;
import com.corso.java.esercitazione.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v2")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getById(@PathParam("id") String id) {
        Employee e = employeeService.getById(id);
        return (e != null) ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathParam("id") String id) {
        Employee e = employeeService.deleteEmployeeById(id);

        return (e != null) ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }
}

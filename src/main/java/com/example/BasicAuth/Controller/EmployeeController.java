package com.example.BasicAuth.Controller;

import com.example.BasicAuth.Entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EmployeeController {
    @GetMapping("/employees")
    public List<Employee> getStudents() {
        return List.of(
                new Employee(1, "Arun"),
                new Employee(2, "Divya"),
                new Employee(3, "Kumar")
        );
    }
}
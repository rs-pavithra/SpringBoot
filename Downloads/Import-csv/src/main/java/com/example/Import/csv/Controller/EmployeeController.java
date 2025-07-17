package com.example.Import.csv.Controller;

import com.example.Import.csv.Entity.Employee;
import com.example.Import.csv.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        employeeService.saveEmployeesFromCsv(file);
        return ResponseEntity.ok("CSV uploaded successfully.");
    }
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
    @GetMapping("/api/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

}

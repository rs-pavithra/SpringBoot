package com.example.Pagination.Controller;

import com.example.Pagination.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/import")
    public String importCsv(@RequestParam("file") MultipartFile file) {
        employeeService.importCsv(file);
        return "CSV data imported successfully.";
    }
}

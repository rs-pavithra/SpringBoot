package com.example.Import.csv.Service;
import com.example.Import.csv.Entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeeService {
    void saveEmployeesFromCsv(MultipartFile file);
    List<Employee> getAllEmployees(); // ✅ THIS is important!
}



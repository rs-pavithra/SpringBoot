package com.example.Pagination.Service;

import com.example.Pagination.Entity.Employee;
import com.example.Pagination.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }


    public void importCsv(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<Employee> employees = new ArrayList<>();
            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Employee employee = new Employee();
                employee.setId(Long.parseLong(data[0].trim()));
                employee.setFirstname(data[1].trim());
                employee.setLastname(data[2].trim());
                employee.setEmail(data[3].trim());
                employees.add(employee);
            }
            employeeRepository.saveAll(employees);
        } catch (Exception e) {
            throw new RuntimeException("CSV import failed: " + e.getMessage());
        }
    }
}

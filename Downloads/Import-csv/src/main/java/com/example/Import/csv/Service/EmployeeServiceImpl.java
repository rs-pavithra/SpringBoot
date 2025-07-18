package com.example.Import.csv.Service;


import com.example.Import.csv.Entity.Employee;
import com.example.Import.csv.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployeesFromCsv(MultipartFile file) {
        try {
            List<Employee> employees = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));

            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                // Skip header
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                // Check if we have all 4 columns
                if (data.length >= 4) {
                    Employee employee = new Employee();
                    employee.setId(Long.parseLong(data[0].trim()));
                    employee.setFirstname(data[1].trim());
                    employee.setLastname(data[2].trim());
                    employee.setEmail(data[3].trim());

                    employees.add(employee);
                }
            }

            employeeRepository.saveAll(employees);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to store CSV data: " + e.getMessage());
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}

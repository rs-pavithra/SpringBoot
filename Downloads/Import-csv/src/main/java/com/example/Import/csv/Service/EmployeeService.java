package com.example.Import.csv.Service;

import com.example.Import.csv.Entity.Employee;
import com.example.Import.csv.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveAll(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }
}


package com.example.Import.csv.Service;

import com.example.Import.csv.Entity.Employee;
import com.example.Import.csv.Repository.EmployeeRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    @Override
    public void saveEmployeesFromCsv(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(reader)
                    .withType(Employee.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Employee> employees = csvToBean.parse();
            repo.saveAll(employees);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse CSV file", e);
        }
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }
}

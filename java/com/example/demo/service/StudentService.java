package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setDepartment(updatedStudent.getDepartment());
                    student.setEmail(updatedStudent.getEmail());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    updatedStudent.setId(id);
                    return studentRepository.save(updatedStudent);
                });
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

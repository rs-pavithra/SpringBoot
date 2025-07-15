package com.example.StudentLaptop.Repository;

import com.example.StudentLaptop.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

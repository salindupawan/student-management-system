package com.project.studentmanagement.services;


import com.project.studentmanagement.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Page<Student> getStudents(String keyword,Pageable pageable);
    Student getStudentById(Long id);
    Student getStudentByEmail(String email);
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}

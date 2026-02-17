package com.project.studentmanagement.services.impl;

import com.project.studentmanagement.entities.Student;
import com.project.studentmanagement.repositories.StudentRepository;
import com.project.studentmanagement.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Page<Student> getStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student current = getStudentById(id);
        current.setFirstName(student.getFirstName());
        current.setLastName(student.getLastName());
        current.setEmail(student.getEmail());
        current.setPhone(student.getPhone());

        return studentRepository.save(current);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

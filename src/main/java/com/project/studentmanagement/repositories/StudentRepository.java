package com.project.studentmanagement.repositories;

import com.project.studentmanagement.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByFirstNameContainingIgnoreCase(String firstName, Pageable pageable);
    Optional<Student> findByEmail(String email);
}

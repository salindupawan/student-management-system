package com.project.studentmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name" ,length = 20, nullable = false)
    private String firstName;

    @Column(name = "last_name" ,length = 20, nullable = false)
    private String lastName;

    @Column(name = "email" ,length = 100, nullable = false)
    private String email;

    @Column(name = "phone" ,length = 10, nullable = false)
    private String phone;

    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

}

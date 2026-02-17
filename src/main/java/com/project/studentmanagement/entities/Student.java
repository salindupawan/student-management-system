package com.project.studentmanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "First name is required.")
    @Column(name = "first_name" ,length = 20, nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Column(name = "last_name" ,length = 20, nullable = false)
    private String lastName;

    @Email(message = "Enter valid email")
    @Column(name = "email" ,length = 100, nullable = false)
    private String email;

    @NotBlank(message = "Phone number is required.")
    @Size(max = 10, message = "Phone number can not exceed 10 character")
    @Column(name = "phone" ,length = 10, nullable = false)
    private String phone;

    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

}

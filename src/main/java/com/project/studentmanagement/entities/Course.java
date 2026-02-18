package com.project.studentmanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course name is required.")
    @Size(max = 50, message = "Course name can not exceed 50 characters")
    @Column(nullable = false, length = 50)
    private String name;

    @NotBlank(message = "Course description is required.")
    @Column( nullable = false)
    private String description;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}

package com.project.studentmanagement.services;

import com.project.studentmanagement.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    public Page<Course> getCourses(Pageable pageable);
    public Course getCourseById(Long id);
    public Course createCourse(Course course);
    public Course updateCourse(Long id, Course course);
    public void deleteCourse(Long id);
}

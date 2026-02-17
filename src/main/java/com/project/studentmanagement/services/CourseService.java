package com.project.studentmanagement.services;

import com.project.studentmanagement.entities.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();
    public Course getCourseById(Long id);
    public Course createCourse(Course course);
    public Course updateCourse(Long id, Course course);
    public void deleteCourse(Long id);
}

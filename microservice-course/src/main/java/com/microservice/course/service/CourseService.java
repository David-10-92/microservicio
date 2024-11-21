package com.microservice.course.service;

import com.microservice.course.dtos.StudentResponse;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface CourseService {

    void createCourse(Course course);
    Course findById(Long id);
    List<Course> findAll();
    StudentByCourseResponse findStudentByCourse(Long idCourse);
}

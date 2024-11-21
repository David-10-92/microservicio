package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dtos.StudentResponse;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository repository;
    private final StudentClient studentClient;

    public CourseServiceImpl(CourseRepository repository, StudentClient studentClient) {
        this.repository = repository;
        this.studentClient = studentClient;
    }

    @Override
    public void createCourse(Course course) {
        repository.save(course);
    }

    @Override
    public Course findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("Course not found"));
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public StudentByCourseResponse findStudentByCourse(Long idCourse) {
        Course course = repository.findById(idCourse).orElse(null);
        List<StudentResponse> studentResponseList = studentClient.findAllStudentByCourse(idCourse);
        assert course != null;
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentResponseList(studentResponseList)
                .build();
    }

}

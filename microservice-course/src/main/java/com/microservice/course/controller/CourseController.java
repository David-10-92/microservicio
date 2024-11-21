package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(Course course){
        service.createCourse(course);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentByCourseResponse> findStudentsByIdCourse(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findStudentByCourse(id));
    }
}

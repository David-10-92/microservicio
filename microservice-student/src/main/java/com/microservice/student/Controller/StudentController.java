package com.microservice.student.Controller;

import com.microservice.student.Service.StudentService;
import com.microservice.student.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody Student student){
        service.createStudent(student);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<Student>> findByIdCourse(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findAllByCourseId(id));
    }
}

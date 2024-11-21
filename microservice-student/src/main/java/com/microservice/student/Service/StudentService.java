package com.microservice.student.Service;

import com.microservice.student.entities.Student;

import java.util.List;

public interface StudentService {

    void createStudent(Student student);
    void updateStudent(Student student);
    Student findById(Long id);
    List<Student> findAll();
    List<Student> findAllByCourseId(Long idCourse);
}

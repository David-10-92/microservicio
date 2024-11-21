package com.microservice.student.Service;

import com.microservice.student.entities.Student;
import com.microservice.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createStudent(Student student) {
        repository.save(student);
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public Student findById(Long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Student> findAllByCourseId(Long idCourse) {
        return repository.findAllByCourseId(idCourse);
    }


}

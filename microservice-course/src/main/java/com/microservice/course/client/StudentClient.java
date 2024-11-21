package com.microservice.course.client;

import com.microservice.course.dtos.StudentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-student", url = "localhost:8080/api/student")
public interface StudentClient {

    @GetMapping("/course/{id}")
    List<StudentResponse> findAllStudentByCourse(@PathVariable("id") Long id);
}

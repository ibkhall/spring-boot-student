package com.webbfontaine.forex_service.student;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("students")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentResponse> findAll() {
    
        return studentService.findAll();
    }

    @PostMapping
    public void createStudent(@RequestBody StudentRequest studentRequest) {
        log.info("Name: "+studentRequest.getName());
        log.info("Age: "+studentRequest.getAge());
        studentService.createStudent(studentRequest);
    }

    @GetMapping("/{id}")
    public Student findStudent(@PathVariable Integer id) {

        return studentService.fidnById(id);
    }

    @PutMapping("/{id}")
    public Student updaStudent(@PathVariable Integer id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }


     @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
    
}

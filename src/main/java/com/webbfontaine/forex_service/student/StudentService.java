package com.webbfontaine.forex_service.student;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    public List<StudentResponse> findAll() {
       
        return studentRepository.findAll()
        .stream()
        .map(studentMapper::studentToStudentResponse).toList();
    }


    public void createStudent(StudentRequest studentRequest) {
        Student student = studentMapper.studentRequestToStudent(studentRequest);

        studentRepository.save(student);
    }


    public Student fidnById(Integer id) {
       return studentRepository.findById(id).orElseThrow();
    }


    public Student updateStudent(Integer id, StudentRequest studentRequest) {
       Student student = this.fidnById(id);

       student.setName(studentRequest.getName());
       student.setAge(studentRequest.getAge());

       return studentRepository.save(student);
    }


    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }


    
}

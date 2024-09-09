package com.webbfontaine.forex_service.student;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student studentRequestToStudent(StudentRequest studentRequest) {

        return Student.builder()
            .name(studentRequest.getName())
            .age(studentRequest.getAge())
            .build();
    }

    public StudentResponse studentToStudentResponse(Student student) {
        return StudentResponse.builder()
        .id(student.getId())
        .name(student.getName())
        .build();
    }
    
}

package com.webbfontaine.forex_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.webbfontaine.forex_service.student.Student;
import com.webbfontaine.forex_service.student.StudentRepository;

@SpringBootApplication
public class ForexServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexServiceApplication.class, args);
	}

	@Bean
    public CommandLineRunner runner(StudentRepository studentRepository) {
		return args -> {
			Student s1 = Student.builder()
			.id(1)
			.name("Ali")
			.age(33)
			.build();

			Student s2 = Student.builder()
			.id(2)
			.name("MOusssa")
			.age(31)
			.build();

			Student s3 = Student.builder()
			.id(3)
			.name("Sani")
			.age(44)
			.build();

			studentRepository.save(s1);
			studentRepository.save(s2);
			studentRepository.save(s3);

		};
 	}

}

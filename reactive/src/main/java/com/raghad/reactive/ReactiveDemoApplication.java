package com.raghad.reactive;

import com.raghad.reactive.student.Student;
import com.raghad.reactive.student.StudentRepository;
import com.raghad.reactive.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(
//			StudentService studentService
//	) {
//		return args -> {
//			for (int i = 0; i < 5; i++) {
//				studentService.saveStudent(
//						Student.builder()
//								.firstName("Raghad " + i)
//								.lastName("Alzamil " + i)
//								.age(i)
//								.build()
//				).subscribe();
//			}
//		};
//	}
}

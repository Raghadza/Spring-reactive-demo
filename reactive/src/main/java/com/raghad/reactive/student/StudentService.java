package com.raghad.reactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Mono<Student> createStudent(Student student) {
        return studentRepository.save(
                Student.builder()
                        .firstName(student.getFirstName())
                        .lastName(student.getLastName())
                        .age(student.getAge())
                .build()
        );
    }

    public Flux<Student> findAll() {
        return studentRepository.findAll();
    }
    public Mono<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public Mono<Student> updateStudent(Integer id,Student student) {
        return studentRepository.findById(student.getId())
                .flatMap(
                        existing -> {
                            existing.setFirstName(student.getFirstName());
                            existing.setLastName(student.getLastName());
                            existing.setAge(student.getAge());

                            return studentRepository.save(existing);
                        })
                .switchIfEmpty(
                        Mono.error(
                                new ResponseStatusException(HttpStatus.NOT_FOUND,
                                        String.format("Student with id %d not found", student.getId())
                                )
                        )
                );
    }

    public Mono<ResponseEntity<String>> deleteById(Integer id) {
        return studentRepository.findById(id)
                .flatMap(student ->
                        studentRepository.delete(student)
                                .thenReturn(ResponseEntity.ok("Student deleted successfully."))
                )
                .switchIfEmpty(Mono.fromCallable(() -> {
                    System.out.println("ID not found: " + id);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("Student not found with ID: " + id);
                }));
    }}

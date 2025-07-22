package com.raghad.reactive.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @PostMapping
    public Mono<Student> createStudent(@RequestBody Student student) {
       return studentService.createStudent(student);
    }

    @GetMapping
    public Flux<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable Integer id) {
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Student> update(@PathVariable Integer id, @RequestBody Student student) {
        return studentService.updateStudent(id,student);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        studentService.deleteById(id);
    }
}

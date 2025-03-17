package org.edu.miu.cs.cs425.eregistrarwebapi.controller;

import org.edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import org.edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registrar")
public class RegistrarController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public List<Student> listStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @GetMapping("/get/{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}

package org.edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrar")
public class RegistraController {
    @PostMapping("/register-student")
    public String registerStudent() {
        return "Student Registered by REGISTRAR";
    }

    @GetMapping("/students")
    public String viewStudents() {
        return "Viewing student list by REGISTRAR";
    }
}

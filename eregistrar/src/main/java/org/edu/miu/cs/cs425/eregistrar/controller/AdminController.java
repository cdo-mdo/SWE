package org.edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @PostMapping("/register-student")
    public String registerStudent() {
        return "Student Registered by ADMIN";
    }

    @PutMapping("/update-student")
    public String updateStudent() {
        return "Student Updated by ADMIN";
    }

    @DeleteMapping("/delete-student")
    public String deleteStudent() {
        return "Student Deleted by ADMIN";
    }
}

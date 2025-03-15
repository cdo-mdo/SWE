package org.edu.miu.cs.cs425.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.edu.miu.cs.cs425.eregistrar.model.Student;
import org.edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.propertyeditors.CustomNumberEditor;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Handle empty strings as null for all requests
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
    }

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getStudents("", 0, 10));
        return "students"; // ✅ Returns Thymeleaf HTML page
    }

    @GetMapping("/**")
    public String handleUnknownRequests() {
        return "redirect:/students";
    }

}

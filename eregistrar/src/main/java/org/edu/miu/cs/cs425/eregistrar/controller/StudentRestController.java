package org.edu.miu.cs.cs425.eregistrar.controller;

import org.edu.miu.cs.cs425.eregistrar.model.Student;
import org.edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // ✅ Handles JSON API requests
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/search")
    public Page<Student> searchStudents(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "studentId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        return studentService.getStudents(keyword, page, size, sortBy, sortDirection);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting student.");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Map<String, String> payload) {
        try {
            Long studentId = Long.parseLong(payload.get("studentId"));
            String columnName = payload.get("columnName");
            String newValue = payload.get("value");

            studentService.updateStudent(studentId, columnName, newValue);
            return ResponseEntity.ok("Student updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student.");
        }
    }
}

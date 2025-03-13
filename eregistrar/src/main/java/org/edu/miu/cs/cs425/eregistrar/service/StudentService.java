package org.edu.miu.cs.cs425.eregistrar.service;

import org.edu.miu.cs.cs425.eregistrar.model.Student;
import org.edu.miu.cs.cs425.eregistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Page<Student> getStudents(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        // ✅ If no keyword is provided, return all students
        if (keyword == null || keyword.trim().isEmpty()) {
            return studentRepository.findAll(pageable);
        }

        return studentRepository.searchStudents(keyword, pageable);
    }

    public Page<Student> getStudents(String keyword, int page, int size, String sortBy, String sortDirection) {
        Pageable pageable = PageRequest.of(page, size,
                sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());

        if (keyword == null || keyword.trim().isEmpty()) {
            return studentRepository.findAll(pageable);
        }

        return studentRepository.searchStudents(keyword, pageable);
    }

    // Get students with filtering
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public void updateStudent(Long studentId, String columnName, String newValue) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));

        switch (columnName) {
            case "studentNumber": student.setStudentNumber(newValue); break;
            case "firstName": student.setFirstName(newValue); break;
            case "middleName": student.setMiddleName(newValue); break;
            case "lastName": student.setLastName(newValue); break;
            case "cgpa": student.setCgpa(newValue.isEmpty() ? null : Double.parseDouble(newValue)); break;
            case "enrollmentDate": student.setEnrollmentDate(LocalDate.parse(newValue)); break;
            case "isInternational": student.setInternational(newValue.equalsIgnoreCase("Yes")); break;
        }

        studentRepository.save(student);
    }
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    // Bulk delete students
    public void deleteStudents(List<Long> studentIds) {
        studentRepository.deleteByStudentIdIn(studentIds);
    }
}

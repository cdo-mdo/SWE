package org.edu.miu.cs.cs425.eregistrarwebapi.service;

import org.edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import org.edu.miu.cs.cs425.eregistrarwebapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setStudentNumber(studentDetails.getStudentNumber());
        student.setFirstName(studentDetails.getFirstName());
        student.setMiddleName(studentDetails.getMiddleName());
        student.setLastName(studentDetails.getLastName());
        student.setCgpa(studentDetails.getCgpa());
        student.setEnrollmentDate(studentDetails.getEnrollmentDate());
        student.setIsInternational(studentDetails.getIsInternational());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}

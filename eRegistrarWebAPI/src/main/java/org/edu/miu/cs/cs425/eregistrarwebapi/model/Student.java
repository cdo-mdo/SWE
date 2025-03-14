package org.edu.miu.cs.cs425.eregistrarwebapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(unique = true, nullable = false)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private Double cgpa;

    @Column(nullable = false)
    private LocalDate enrollmentDate;

    private boolean isInternational;

    public Student() {
        super();
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName,
                   Double cgpa, LocalDate enrollmentDate, boolean isInternational) {
        super();
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public boolean getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(boolean isInternational) {
        this.isInternational = isInternational;
    }
}

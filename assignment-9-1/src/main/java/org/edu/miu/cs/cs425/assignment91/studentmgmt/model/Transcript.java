package org.edu.miu.cs.cs425.assignment91.studentmgmt.model;

import jakarta.persistence.*;

@Entity
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String degreeTitle;

    @OneToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    public Transcript() {

    }
    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }
    public Transcript(String degreeTitle, Student student) {
        this.degreeTitle = degreeTitle;
        this.student = student;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDegreeTitle() {
        return degreeTitle;
    }
    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
}

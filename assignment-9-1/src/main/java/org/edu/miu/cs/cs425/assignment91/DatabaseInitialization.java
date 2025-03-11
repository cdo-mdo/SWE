package org.edu.miu.cs.cs425.assignment91;

import org.edu.miu.cs.cs425.assignment91.studentmgmt.model.Classroom;
import org.edu.miu.cs.cs425.assignment91.studentmgmt.model.Course;
import org.edu.miu.cs.cs425.assignment91.studentmgmt.model.Student;
import org.edu.miu.cs.cs425.assignment91.studentmgmt.model.Transcript;
import org.edu.miu.cs.cs425.assignment91.studentmgmt.repository.ClassroomRepository;
import org.edu.miu.cs.cs425.assignment91.studentmgmt.repository.CourseRepository;
import org.edu.miu.cs.cs425.assignment91.studentmgmt.repository.StudentRepository;
import org.edu.miu.cs.cs425.assignment91.studentmgmt.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatabaseInitialization implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TranscriptRepository transcriptRepository;

    Classroom classroom1, classroom2, classroom3;

    Course course1, course2, course3;

    Transcript transcript1, transcript2, transcript3;

    Student student1, student2, student3;

    private void initClassrooms() {
        classroom1 = new Classroom("Verrill Hall", "V11");
        classroom2 = new Classroom("Verrill Hall", "V29");
        classroom3 = new Classroom("Verrill Hall", "V44");
        classroomRepository.save(classroom1);
        classroomRepository.save(classroom2);
        classroomRepository.save(classroom3);
    }

    private void initCourses() {
        course1 = new Course("STC", "Science Technology Consciousness");
        course2 = new Course("FPP", "Fundamental Programming Practice");
        course3 = new Course("MPP", "Modern Programming Practice");
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
    }

    private void initTranscripts() {
        transcript1 = new Transcript("MSC");
        transcript2 = new Transcript("BSC");
        transcript3 = new Transcript("MSC");
        transcript1.setStudent(student1);
        transcript2.setStudent(student2);
        transcript3.setStudent(student3);

        transcriptRepository.save(transcript1);
        transcriptRepository.save(transcript2);
        transcriptRepository.save(transcript3);
    }

    private void initStudents() {
        student1 = new Student("000-61-0001", "Anna", "Lynn", "Smith",
                3.45, LocalDate.of(2019, 5, 24));
        student2 = new Student("000-61-0020", "Juan", "", "Carlos",
                3.55, LocalDate.of(2020, 8, 3));

        student3 = new Student("000-61-0047", "John", "Alexandre", "Martin",
                3.55, LocalDate.of(2021, 10, 28));

        student1.setTranscript(transcript1);
        student2.setTranscript(transcript2);
        student3.setTranscript(transcript3);

        student1.setClassroom(classroom1);
        student2.setClassroom(classroom2);
        student3.setClassroom(classroom3);

        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course3);

        student2.addCourse(course1);
        student2.addCourse(course2);
        student2.addCourse(course3);

        student3.addCourse(course1);
        student3.addCourse(course2);
        student3.addCourse(course3);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

    }

    @Override
    public void run(String... args) throws Exception {
        initClassrooms();
        initCourses();
        initStudents();
        initTranscripts();
    }
}

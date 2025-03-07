package org.edu.miu.cs.cs452.studentrecordsmgmtapp;

import org.edu.miu.cs.cs452.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {
    public void printListOfStudentRecords(List<Student> students) {
        students.sort(Comparator.comparing(Student::getName));
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public List<Student> getListOfPlatinumAlumniStudents(List<Student> students) {
        LocalDate thirtyYearsAgo = LocalDate.now().minusYears(30);

        return students.stream()
                .filter(student -> {
                    LocalDate admissionDate = student.getDateOfAdmission()
                            .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return admissionDate.isBefore(thirtyYearsAgo);
                })
                .collect(Collectors.toList());
    }

    public void printHelloWorld(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.println("Hello World");
                continue;
            }
            if (number % 5 == 0) {
                System.out.println("Hello");
                continue;
            }
            if (number % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public int findSecondBiggest(List<Integer> numbers) {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("List must contain at least two numbers.");
        }

        int secondBiggest = Integer.MIN_VALUE;
        int biggest = Integer.MIN_VALUE;
        for (Integer number : numbers) {
            if (number > biggest) {
                secondBiggest = biggest;
                biggest = number;
            }
            else if (number > secondBiggest && number < biggest) {
                secondBiggest = number;
            }
        }

        if (secondBiggest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("List must contain at least two distinct numbers.");
        }

        return secondBiggest;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1951, Calendar.NOVEMBER, 18);
        students.add(new Student("110001", "Dave", calendar.getTime()));
        calendar.set(1990, Calendar.DECEMBER, 7);
        students.add(new Student("110002", "Anna", calendar.getTime()));
        calendar.set(1974, Calendar.JANUARY, 31);
        students.add(new Student("110003", "Erica", calendar.getTime()));
        calendar.set(2009, Calendar.AUGUST, 22);
        students.add(new Student("110004", "Carlos", calendar.getTime()));
        calendar.set(1994, Calendar.AUGUST, 5);
        students.add(new Student("110005", "Bob", calendar.getTime()));

        MyStudentRecordsMgmtApp app = new MyStudentRecordsMgmtApp();

        System.out.println("List of student records:\n");
        app.printListOfStudentRecords(students);
        System.out.println();

        System.out.println("List of student in platinum alumni:\n");
        app.getListOfPlatinumAlumniStudents(students).stream()
                .sorted(Comparator.comparing(Student::getDateOfAdmission).reversed())
                .forEach(System.out::println);
        System.out.println();

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 35, 10);
        app.printHelloWorld(nums);

        System.out.println("\nSecond largest number:");
        System.out.println(app.findSecondBiggest(nums));
    }
}

package org.edu.miu.cs.cs452;

import org.edu.miu.cs.cs452.model.Patient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");


        Calendar calendar = Calendar.getInstance();


        List<Patient> patients = new ArrayList<Patient>();

        calendar.set(1999, Calendar.OCTOBER, 21);
        patients.add(new Patient(1, "firstName1", "lastName1",
                calendar.getTime(), "email1@personal.com", "phone1", "address1"));

        calendar.set(1998, Calendar.NOVEMBER, 22);
        patients.add(new Patient(1, "firstName2", "lastName2",
                calendar.getTime(), "email2@personal.com", "phone2", "address2"));

        calendar.set(1997, Calendar.DECEMBER, 20);
        patients.add(new Patient(1, "firstName3", "lastName3",
                calendar.getTime(), "email3@personal.com", "phone3", "address3"));


        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
}
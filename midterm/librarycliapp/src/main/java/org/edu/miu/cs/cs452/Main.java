package org.edu.miu.cs.cs452;

import org.edu.miu.cs.cs452.model.Publisher;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        List<Publisher> publishers = new ArrayList<Publisher>();
        publishers.add(new Publisher("id", "name1", "phone1", "email1"));
        publishers.add(new Publisher("id2", "name2", "phone2", "email2"));
        publishers.add(new Publisher("id3", "name3", "phone3", "email3"));

        for (Publisher publisher : publishers) {
            System.out.println(publisher.toString());
        }
    }
}
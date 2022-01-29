package com.sda.javaee9spring.controller;

import com.sda.javaee9spring.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/person")
public class PersonController {

    public static final String PERSONS_KEY = "personsKey";

    @GetMapping("/names")
        public String showListOfPersonsNames(Model data) {
        // with var Java is going to guess type of the variable based on assigned value
//        var name = "mariusz"; // String name = "mariusz";
//        var mariusz = new Person("Mariusz", "Pastuszka", 18);
//        Person mariusz = new Person("Mariusz", "Pastuszka", 18);
//        var mariusz = null; // need initialization value, without that it won't work
        ArrayList<Person> myBestFriends = new ArrayList<Person>(); // till Java 7
        ArrayList<Person> myBestFriendsJava7 = new ArrayList<>(); // since Java 7
        var myBestFriendsJava10 = new ArrayList<Person>(); // since Java 10
        var myBestFriendsJava10v2 = new ArrayList<>(); // since Java 10
        var myBestFriendsJava10v3 = new ArrayList<Object>(); // since Java 10

        // this list will be dynamic in the future:)
//        List<Person> persons
                var persons
        =List.of(
                new Person("Mariusz", "Pastuszka", 18),
                new Person("Alicja", "Strus", 25),
                new Person("Joe", "Doe", 40)
        );

                data.addAttribute(PERSONS_KEY, persons);
        return "persons/persons-names";
    }
}

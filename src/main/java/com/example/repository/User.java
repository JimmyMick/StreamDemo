package com.example.repository;

import com.example.model.Person;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static Faker faker = new Faker();

    private static List<Person> users = new ArrayList<>();

    private static final String commonCompany = faker.company().name();

    static {

        System.out.println(commonCompany);

        for (int i = 0; i < 100; i++) {
            users.add(
                    new Person(
                            faker.name().firstName(),
                            faker.name().lastName(),
                            (i%7==0?commonCompany:faker.company().name()),
                            faker.number().numberBetween(20, 80)
                    )
            );
        }
    }

    public static List<Person> getUsers(){
        return users;
    }
}

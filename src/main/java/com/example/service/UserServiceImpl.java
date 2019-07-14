package com.example.service;

import com.example.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<Person> getUsers() {

        List<Person> users = new ArrayList<>();

        users.add(new Person("Jim", "McLaughlin", "YRC"));
        users.add(new Person("Diane", "Estes", "YRC"));
        users.add(new Person("Billy", "Korando", "IBM"));
        users.add(new Person("Rob", "Winch", "Pivotal"));

        return users;
    }
}

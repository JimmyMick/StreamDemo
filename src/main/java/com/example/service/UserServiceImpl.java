package com.example.service;

import com.example.model.Person;
import com.example.repository.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<Person> getUsers(String co) {

        List<Person> ppl = User.getUsers();

        List<Person> users = ppl.stream()    // create a stream
                .filter( usr -> co == null || co.equalsIgnoreCase(usr.getCompany())) // filter if the co value is given
                .sorted( (a, b) -> a.getAge() - b.getAge() )  // sort items being streamed by age
                .collect( Collectors.toList());  //  stream them into a collection

        return users;
    }
}

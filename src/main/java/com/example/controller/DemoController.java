package com.example.controller;

import com.example.model.Person;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DemoController {

    @Resource
    UserService userSvc;

    @GetMapping(value = "/users", produces = "application/json")
    public List<Person> getUsers(
            @RequestParam(value="co", required = false)String co
    ) {

        return userSvc.getUsers(co);
    }
}

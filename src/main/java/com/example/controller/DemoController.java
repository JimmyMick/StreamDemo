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
    public ResponseEntity<List<String>> getUsers(
            @RequestParam(value="co", required = false)String co
    ) {

        List<Person> ppl = userSvc.getUsers();

        List<String> users = ppl.stream()    // create a stream
                .filter( usr -> co == null || co.equalsIgnoreCase(usr.getCompany())) // filter if the co value is given
                .map( usr -> usr.getName() )  // map the Person down to just the name
//              .map( Person::getName )  // this syntax (i.e. method reference) can be used to further simplify the call
                .sorted()  // sort items being streamed
                .collect( Collectors.toList());  //  stream them into a collection

        return (new ResponseEntity<List<String>>(users, HttpStatus.OK));
    }
}

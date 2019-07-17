package com.example.model;

public class Person {
    String firstName;
    String lastName;
    String company;
    int age;

    public Person() {
    }

    public Person(String firstName, String lastName, String company, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.age = age;
    }

    public String getName(){
        return getFirstName() + " " + getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }


}

package com.example.tests;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTests {

    class Person{
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    private Faker faker;


    @Before
    public void setup(){
        faker = new Faker();
    }

    @Test
    public void testParallelPerformance() {

        List < Person > peopleList = new ArrayList < > ();

        for (int i = 0; i < 50000; i++) {
            peopleList.add(new Person(faker.name().firstName(), faker.number().numberBetween(20, 60)));
        }




        long streamStartTime = System.currentTimeMillis();
        System.out.println(peopleList.stream().filter(value -> value.getAge() % 2 == 0).mapToInt( p -> p.getAge() ).count());
        long streamEndTime = System.currentTimeMillis();
        System.out.println("Stream of Object total Time = " + (streamEndTime - streamStartTime));

        long parallelStreamStartTime = System.currentTimeMillis();
        System.out.println(peopleList.parallelStream().filter(value -> value.getAge() % 2 == 0).mapToInt( p -> p.getAge() ).count());
        long parallelStreamEndTime = System.currentTimeMillis();
        System.out.println("Parallel Stream of Object total Time = " + (parallelStreamEndTime - parallelStreamStartTime));

        List < Integer > intList = new ArrayList < > ();

        for (int i = 0; i < 5000000; i++) {
            intList.add( i );
        }

        streamStartTime = System.currentTimeMillis();
        System.out.println( intList.stream().filter(value -> value % 2 == 0).mapToInt( Integer::intValue ).count() );
        streamEndTime = System.currentTimeMillis();
        System.out.println("Stream of Integer total Time = " + (streamEndTime - streamStartTime));

        parallelStreamStartTime = System.currentTimeMillis();
        System.out.println( intList.parallelStream().filter(value -> value % 2 == 0).mapToInt( Integer::intValue ).count() );
        parallelStreamEndTime = System.currentTimeMillis();
        System.out.println("Parallel Stream of Integer total Time = " + (parallelStreamEndTime - parallelStreamStartTime));


    }

}

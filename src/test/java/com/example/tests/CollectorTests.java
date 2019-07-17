package com.example.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class CollectorTests {

    class President{
        public String name;
        public int number;
        public President(String nm, int no ){
            name = nm;
            number = no;
        }
    }

    private ArrayList<President> presidents = new ArrayList<>();

    @Before
    public void setup(){
        presidents.addAll(Arrays.asList(
                new President ("George", 1),
                new President ("John", 2),
                new President ("Thomas", 3),
                new President ("James",4),
                new President ("James", 5)
        ));

    }

    @Test
    public void sourceTest() {


        presidents.stream().forEach( p -> {
            p.name = p.name.toLowerCase();
            System.out.println(p.name);
        });


        List<President> results = presidents.stream().filter(n -> {

            if(n.number == 99){
                return false;
            }

            if (n.number == 2) {
                n.name = "Johnny";

//                        presidents.add(new President("John Quincy",6));
// would cause java.util.ConcurrentModificationException
            }
            n.name = n.name.toUpperCase();


            return true;
        }).collect(Collectors.toList());


        results.forEach( p -> {
            System.out.println(p.name);
        });

    }
}

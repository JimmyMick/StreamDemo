package com.example.tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class ReduceTests {

    class President{
        public String name;
        public int number;
        public String party;
        public int age;
        public President(String nm, int no, String party, int age ){
            this.name = nm;
            this.number = no;
            this.party = party;
            this.age = age;
        }
    }

    private ArrayList<President> presidents = new ArrayList<>();

    @Before
    public void setup(){
        presidents.addAll(Arrays.asList(
                new President ("George", 1, "Independent", 57),
                new President ("John", 2, "Federalist", 61),
                new President ("Thomas", 3, "Democratic-Republican", 57),
                new President ("James",4, "Democratic-Republican", 57),
                new President ("James", 5, "Democratic-Republican", 58)
        ));

    }

    class Summary{
        public int federalistCnt = 0;
        public int democraticRepublicanCnt = 0;
        public int otherCnt = 0;
    }

    @Test
    public void oldestTest() {

        Optional<President> oldest =  presidents.stream().reduce( (p1, p2) -> p1.age>p2.age?p1:p2  );

        assertTrue(oldest.isPresent());

        System.out.println( "Oldest Founding Father President = " + oldest.get().name);

    }
}

package com.example.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamModificationTest {

    @DisplayName("Source Modification Test")
    @Test
    void sourceTest() {

        class President{
            public String name;
            public int number;
            public President(String nm, int no ){
                name = nm;
                number = no;
            }
        }

        ArrayList<President> presidents = new ArrayList<>();

        presidents.addAll(Arrays.asList(
                new President ("George", 1),
                new President ("John", 2),
                new President ("Thomas", 3),
                new President ("James",4)
        ));

        presidents.add( new President("James",5));

        presidents.forEach( p -> {
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

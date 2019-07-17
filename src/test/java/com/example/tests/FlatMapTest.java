package com.example.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {


    @Test
    public void testFlatMap(){

        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);

        List<String> results =  list.stream().flatMap( lstOfString -> lstOfString.stream() ).collect(Collectors.toList());

        System.out.println(results);

    }
}

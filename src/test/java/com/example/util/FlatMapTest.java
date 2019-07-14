package com.example.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {

    @DisplayName("Flat Map Test")
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

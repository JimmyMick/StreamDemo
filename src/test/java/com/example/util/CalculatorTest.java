package com.example.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @DisplayName("Lambda Test")
    @Test
    void sum() {

        Calculator<Integer, Integer> calc = (a,b) -> a+b;
        assertEquals( 30, calc.sum(10,20));

        Calculator<String, String> strCalc = (a,b) -> {
          int x = Integer.parseInt(a);
          int y = Integer.parseInt(b);
          return x+y;
        };

        assertEquals(80, strCalc.sum("50","30"));
    }



}
package com.example.tests;

import java.lang.FunctionalInterface;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class FunctionalInterfaceTests {

    @FunctionalInterface
    interface ShowTime{
        Calendar now();
    }

    @FunctionalInterface
    interface CalculateSum<T,R>{
        long add(T a, R b);
    };

    @FunctionalInterface
    interface CalculateIntSum{
        int add(int a, int b);
    }

    private ShowTime thisIsAnAnonymousClassExample = new ShowTime(){
        public Calendar now() {
            return Calendar.getInstance();
        }
    };


    @Test
    public void testZeroParams(){

        ShowTime theTime = ()-> Calendar.getInstance();

        Calendar rightNow = theTime.now();

        assertEquals(Calendar.getInstance().getTime().toString(), rightNow.getTime().toString());
    }

    @Test
    public void testMultipleParams(){

        CalculateSum<String, String> sumStrings = (a , b) -> {
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            return x+y;
        };

        CalculateIntSum addInts = (a, b) -> a+b;

        assertEquals(80, sumStrings.add("50","30"));

        assertEquals(100, addInts.add(90,10) );

    }


}

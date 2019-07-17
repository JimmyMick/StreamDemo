package com.example.tests;

import org.junit.Test;

public class MethodReferenceTests {

    @FunctionalInterface
    interface Logger<T>{
        void log(T foo);
    }

    @FunctionalInterface
    interface StrLogger{
        void log(String s);
    }

    @FunctionalInterface
    interface UpperCaseIt{
        String toUpper(String s);
    }

    @Test
    public void instanceMethod(){

        StrLogger myLogger = (s) -> {
            System.out.println(s);
        };

        myLogger.log("Hello, KCDC");

    }

    @Test
    public void staticMethod(){

        UpperCaseIt upperCaseUtil = s -> s.toUpperCase();

        System.out.println( upperCaseUtil.toUpper("kcdc is always informative") );

    }

}

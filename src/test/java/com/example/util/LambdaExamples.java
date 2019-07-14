package com.example.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LambdaExamples {

    @FunctionalInterface
    interface LogTime{
        public void now();
    }

    @FunctionalInterface
    interface MyLogger<T>{
        public void log(T item);
    }

    @DisplayName("Zero and One Parameter Lambdas")
    @Test
    void zeroAndOne() {

        MyLogger<String> logger = text -> System.out.println(text);

        logger.log("hello world");

        Locale l = Locale.forLanguageTag("no-NO");
        LogTime timeLogger = () -> {

            TimeZone timeZone = TimeZone.getTimeZone("Europe/Oslo");
            Calendar calendar = Calendar.getInstance(timeZone);
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("EE MMM dd HH:mm:ss zzz yyyy", Locale.forLanguageTag("no-NO"));
            simpleDateFormat.setTimeZone(timeZone);

            System.out.println("Time zone: " + timeZone.getID());
            System.out.println("default time zone: " + TimeZone.getDefault().getID());
            System.out.println();

            System.out.println("UTC:     " + simpleDateFormat.format(calendar.getTime()));
            System.out.println("Default: " + calendar.getTime());
        };

        timeLogger.now();

    }





}
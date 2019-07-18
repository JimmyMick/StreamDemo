package com.example.tests;

import com.github.javafaker.Beer;
import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapTest {

    @Test
    public void flatMapTest(){

        List<List<String>> list = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));
        System.out.println(list);

        List<String> results =  list.stream().flatMap( lstOfString -> lstOfString.stream() ).collect(Collectors.toList());

        System.out.println(results);

    }

    @Test
    public void mapTest(){

        Faker faker = new Faker();

        Supplier<Beer> randomBeerSupplier = faker::beer;

        Stream<Beer> randomBeerStream = Stream.generate(randomBeerSupplier);

        List<String> beers = randomBeerStream.skip(5).limit(10).map( b -> b.name() + " - " + b.style()).collect(Collectors.toList());

        beers.forEach( System.out::println);


    }

}

package com.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

// org.junit.jupiter:junit-jupiter-params:5.7.0
public class UseParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints={4,8,15,16,23,42})
    void test1(int i){
        System.err.println("Running test for the value "+i);
    }

    @ParameterizedTest
    @ValueSource(strings={"jack", "kate", "james", "sun", "jin"})
    @NullAndEmptySource
    void test2(String name){
        System.err.println("Running test for the value "+name);
    }

    @ParameterizedTest
    @EnumSource(FiatCurrency.class)
    void test3(FiatCurrency currency){
        System.err.println("Running test for the value "+currency.name());
    }

    @ParameterizedTest
    @MethodSource({"generateSequentialNumbers","generateRandomNumbers"})
    void test4(int i){
        System.err.println("Running test for the value "+i);
    }

    @ParameterizedTest
    @CsvSource({
        "ankara,312",
        "istanbul-avrupa,212",
        "istanbul-anadolu,216"
    })
    void test5(String city,int code){
        System.err.println(city+": "+code);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/area-codes-turkey.csv","/area-codes-usa.csv"})
    void test6(String city,int code){
        System.err.println(city+": "+code);
    }


    static List<Integer> generateSequentialNumbers(){
        return IntStream.range(0,10).boxed().collect(Collectors.toList());
    }

    static List<Integer> generateRandomNumbers(){
        return ThreadLocalRandom.current().ints(1,100)
                .limit(10).boxed().collect(Collectors.toList());
    }


}

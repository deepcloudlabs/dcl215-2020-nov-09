package com.example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class UseRepeatedTest {
    @RepeatedTest(10)
    void test1(RepetitionInfo info){
        System.err.println(String.format("Running %d of %d",
                info.getCurrentRepetition(),
                info.getTotalRepetitions()));
    }
}

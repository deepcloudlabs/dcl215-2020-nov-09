package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnit5Test {
    @Test
    void test() {
        var numbers = List.of(4,8,15,16,23,42);
        assertEquals(4, numbers.stream().filter(n -> n%2 == 0).count());
    }

}

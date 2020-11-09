package com.example;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumeTest {
    @Test
    public void test1(){
        System.err.println(ZoneId.systemDefault().getId());
        System.err.println(System.getProperty("os.name").toString());
        assumeTrue(ZoneId.systemDefault().getId().contains("Asia"));
        assumeTrue(System.getProperty("os.name").toString().contains("Win"));
        assertEquals(5, 2*2);
    }

    @Test
    public void test2(){
        assumeTrue(ZoneId.systemDefault().getId().contains("Africa") &&
                     System.getProperty("os.version").toString().contains("nix"));
        assertEquals(5, 2+2);
    }
}

package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class UseTimeoutTest {
    @Test
    @Timeout(value=5,unit = TimeUnit.SECONDS)
    void longRunningTest() throws Throwable {
        TimeUnit.SECONDS.sleep(10);
    }
}

package com.example.checkerframework;

import org.junit.jupiter.api.Test;

public class CheckerTest {

    @Test
    void nonNull(){
        Checker checker = new Checker();
        checker.printLength(null);
    }
}

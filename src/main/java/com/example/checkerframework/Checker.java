package com.example.checkerframework;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Checker {

    public void printLength(@NonNull String text) {
        System.out.println(text.length());
    }
}

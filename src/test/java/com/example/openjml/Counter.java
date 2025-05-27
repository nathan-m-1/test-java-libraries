package com.example.openjml;

public class Counter {

    private int count;

    //@ invariant count >= 0;

    //@ ensures count == \old(count) + 1;
    public void increment() {
        count++;
    }

    /**
     * metodo para hacer un decremento en el contador en 1
     * @return void
     */
    //@ requires count > 0;
    //@ ensures count == \old(count) - 1;
    public void decrement() {
        count--;
    }
}

package com.example.openjml;

public class BankAccount {

    private int balance;

    //@ requires amount >= 0;
    //@ ensures balance == \old(balance) + amount;
    public void deposit(int amount) {
        balance += amount;
    }

    //@ requires amount >= 0 && amount <= balance;
    //@ ensures balance == \old(balance) - amount;
    public void withdraw(int amount) {
        balance -= amount;
    }

    //@ ensures \result >= 0;
    public int getBalance() {
        return balance;
    }
}

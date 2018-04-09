package com.javalab.tdd;

public class Calculator {
    public long factorial(long number) {
        if (number <= 0) return 1;
        return factorial(number - 1) * number;
    }
}

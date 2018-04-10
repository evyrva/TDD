package com.javalab.tdd;

import java.util.Arrays;

class Calculator {
    long factorial(long number) {
        if (number <= 0) return 1;
        return factorial(number - 1) * number;
    }

    int multiply(int... nums) {
        int[] res = {1};
        Arrays.stream(nums).forEach(i -> res[0] *= i);
        return res[0];
    }

    double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Divide by zero");
        return (double) a / b;
    }
}

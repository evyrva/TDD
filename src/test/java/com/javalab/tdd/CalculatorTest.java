package com.javalab.tdd;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2, 2", "3, 6"})
    void factorialTest(long input, long expected) {
        long actual = calculator.factorial(input);
        assertThat(expected, is(equalTo(actual)));
    }

    @Ignore
    @Test
    void multiplyTest() {
        int actual = calculator.multiply(1, 2, 3);
        assertThat(6, is(equalTo(actual)));
    }

    @Test
    void divideTest() {
        assertThat(0.5, is(equalTo(calculator.divide(1, 2))));
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }
}
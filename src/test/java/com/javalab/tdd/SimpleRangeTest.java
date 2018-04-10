package com.javalab.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class SimpleRangeTest {

    private SimpleRange simpleRange;
    private static final int lowerBound = 0;
    private static final int upperBound = 10;

    @BeforeEach
    void setUp() {
        simpleRange = new SimpleRange(lowerBound, upperBound);
    }

    @ParameterizedTest
    @CsvSource({"-5, -1, true", "-5, 0, false", "-5, 1, false", "-5, 15, false", "11, 15, false"})
    void isBefore(long lowerBound, long upperBound, boolean expected) {
        assertThat(expected, is(equalTo(simpleRange.isBefore(new SimpleRange(lowerBound, upperBound)))));
    }

    @ParameterizedTest
    @CsvSource({"11, 12, true", "-5, 0, false", "-5, 1, false", "-5, 15, false", "5, 15, false"})
    void isAfter(long lowerBound, long upperBound, boolean expected) {
        assertThat(expected, is(equalTo(simpleRange.isAfter(new SimpleRange(lowerBound, upperBound)))));
    }

    @ParameterizedTest
    @CsvSource({"-5, 0, true", "-5, 1, true", "-5, 15, true", "0, 1, true",
            "1, 2, true", "0, 10, true", "0, 15, true", "1, 15, true", "10, 15, true",
            "-5, -1, false", "11, 15, false"})
    void isConcurrent(long lowerBound, long upperBound, boolean expected) {
        assertThat(expected, is(equalTo(simpleRange.isConcurrent(new SimpleRange(lowerBound, upperBound)))));
    }

    @ParameterizedTest
    @CsvSource({"-5, false", "0, true", "5, true", "10, true", "15, false"})
    void contains(long num, boolean expected) {
        assertThat(expected, is(equalTo(simpleRange.contains(num))));
    }

    @Test
    void asList() {
        Long[] longs = {0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L};
        List<Long> longList = Arrays.asList(longs);
        assertThat(longList, is(equalTo(simpleRange.asList())));
    }

    @Test
    void asIterator() {
        Iterator<Long> iterator = simpleRange.asIterator();
        long expected = 0;
        while (iterator.hasNext()) {
            assertThat(expected++, is(equalTo(iterator.next())));
        }
    }
}
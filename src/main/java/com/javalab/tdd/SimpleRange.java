package com.javalab.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SimpleRange implements Range {
    private long lowerBound;
    private long upperBound;
    private List<Long> longList;

    public SimpleRange(long lowerBound, long upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        longList = asList();
    }

    @Override
    public boolean isBefore(Range otherRange) {
        return otherRange.getUpperBound() < lowerBound;
    }

    @Override
    public boolean isAfter(Range otherRange) {
        return otherRange.getLowerBound() > upperBound;
    }

    @Override
    public boolean isConcurrent(Range otherRange) {
        return otherRange.getLowerBound() >= lowerBound && otherRange.getLowerBound() <= upperBound
                || otherRange.getUpperBound() >= lowerBound && otherRange.getUpperBound() <= upperBound
                || otherRange.getLowerBound() >= lowerBound && otherRange.getUpperBound() <= upperBound
                || otherRange.getLowerBound() <= lowerBound && otherRange.getUpperBound() >= upperBound;
    }

    @Override
    public long getLowerBound() {
        return lowerBound;
    }

    @Override
    public long getUpperBound() {
        return upperBound;
    }

    @Override
    public boolean contains(long value) {
        return value >= lowerBound && value <= upperBound;
    }

    @Override
    public List<Long> asList() {
        List<Long> longList = new ArrayList<>();
        for (long i = lowerBound; i <= upperBound; i++) {
            longList.add(i);
        }
        return longList;
    }

    @Override
    public Iterator<Long> asIterator() {
        return longList.iterator();
    }
}

package com.moqi.java.a04;

import java.util.Iterator;

/**
 * 素数迭代子，Java 实现
 *
 * @author moqi
 * On 3/15/20 13:17
 */

public class A0412PrimeIterator implements Iterator<Integer> {
    private int lastPrime = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return lastPrime = A0411Prime.nextPrimeFrom(lastPrime);
    }

    @Override
    public void remove() {
        throw new RuntimeException("Fundamental nature of the universe exception!");
    }
}
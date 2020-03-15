package com.moqi.java.a06;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.sqrt;

// 命令式的素数判定实现
// BEGIN java_prime_alpha
public class A0616PrimeAlpha {
    private final int number;

    public A0616PrimeAlpha(int number) {
        this.number = number;
    }

    public boolean isPrime() {
        Set<Integer> primeSet = new HashSet<Integer>() {{
            add(1);
            add(number);
        }};
        return number > 1 &&
                factors().equals(primeSet);
    }

    public boolean isFactor(int potential_factor) {
        return number % potential_factor == 0;
    }

    public Set<Integer> factors() {
        //noinspection DuplicatedCode
        HashSet<Integer> factors = new HashSet<>();
        for (int i = 1; i <= sqrt(number); i++)
            if (isFactor(i)) {
                factors.add(i);
                factors.add(number / i);
            }
        return factors;
    }

}
// END java_prime_alpha

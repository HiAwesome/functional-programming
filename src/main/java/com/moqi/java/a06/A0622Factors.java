package com.moqi.java.a06;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.sqrt;

// 经过函数式重构的 Factors 类
// BEGIN java_factors
public class A0622Factors {
    static public boolean isFactor(int number, int potential_factor) {
        return number % potential_factor == 0;
    }

    static public Set<Integer> of(int number) {
        HashSet<Integer> factors = new HashSet<>();
        for (int i = 1; i <= sqrt(number); i++)
            if (isFactor(number, i)) {
                factors.add(i);
                factors.add(number / i);
            }
        return factors;
    }

}
// END java_factors

package com.moqi.java.a06;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.sqrt;

// 经过提取、重构的共通代码
// BEGIN java_factors_beta
public class A0617FactorsBeta {
    protected int number;

    public A0617FactorsBeta(int number) {
        this.number = number;
    }

    public boolean isFactor(int potential_factor) {
        return number % potential_factor == 0;
    }

    public Set<Integer> getFactors() {
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
// END java_factors_beta

package com.moqi.java.a06;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.lang.Math.sqrt;

// 命令式的完美数分类实现
// BEGIN java_classifier_alpha
public class A0615ClassifierAlpha {
    private final int number;

    public A0615ClassifierAlpha(int number) {
        this.number = number;
    }

    static public int sum(Set<Integer> factors) {
        Iterator it = factors.iterator();
        int sum = 0;
        while (it.hasNext())
            sum += (Integer) it.next();
        return sum;
    }

    public boolean isFactor(int potential_factor) {
        return number % potential_factor == 0;
    }

    public Set<Integer> factors() {
        HashSet<Integer> factors = new HashSet<>();
        for (int i = 1; i <= sqrt(number); i++)
            if (isFactor(i)) {
                factors.add(i);
                factors.add(number / i);
            }
        return factors;
    }

    public boolean isPerfect() {
        return sum(factors()) - number == number;
    }

    public boolean isAbundant() {
        return sum(factors()) - number > number;
    }

    public boolean isDeficient() {
        return sum(factors()) - number < number;
    }
}
// END java_classifier_alpha

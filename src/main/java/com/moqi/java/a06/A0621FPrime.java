package com.moqi.java.a06;

import java.util.Set;

// 函数式版本的素数判定程序
// BEGIN java_fprime
public class A0621FPrime {

    public static boolean isPrime(int number) {
        Set<Integer> factors = A0622Factors.of(number);
        return number > 1 &&
                factors.size() == 2 &&
                factors.contains(1) &&
                factors.contains(number);
    }
}
// END java_fprime

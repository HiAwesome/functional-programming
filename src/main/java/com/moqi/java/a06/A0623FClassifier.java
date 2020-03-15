package com.moqi.java.a06;

import java.util.Iterator;

// 经过重构的完美数分类程序
// BEGIN java_fclassifier
public class A0623FClassifier {

    public static int sumOfFactors(int number) {
        Iterator<Integer> it = A0622Factors.of(number).iterator();
        int sum = 0;
        while (it.hasNext())
            sum += it.next();
        return sum;
    }

    public static boolean isPerfect(int number) {
        return sumOfFactors(number) - number == number;
    }

    public static boolean isAbundant(int number) {
        return sumOfFactors(number) - number > number;
    }

    public static boolean isDeficient(int number) {
        return sumOfFactors(number) - number < number;
    }
}
// END java_fclassifier

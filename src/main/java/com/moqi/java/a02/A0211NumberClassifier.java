package com.moqi.java.a02;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 稍微向函数式靠拢的完美数分类实现
 *
 * @author moqi
 * On 3/14/20 20:29
 */

public class A0211NumberClassifier {

    public static boolean isFactor(final int candidate, final int number) {   //<1>
        return number % candidate == 0;
    }

    public static Set<Integer> factors(final int number) {                    //<2>
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(number);
        for (int i = 2; i < number; i++)
            if (isFactor(i, number))
                factors.add(i);
        return factors;
    }

    public static int aliquotSum(final Collection<Integer> factors) {
        int sum = 0;
        int targetNumber = Collections.max(factors);
        for (int n : factors) {                                               //<3>
            sum += n;
        }
        return sum - targetNumber;
    }

    public static boolean isPerfect(final int number) {
        return aliquotSum(factors(number)) == number;
    }

    //<4>
    public static boolean isAbundant(final int number) {
        return aliquotSum(factors(number)) > number;
    }

    public static boolean isDeficient(final int number) {
        return aliquotSum(factors(number)) < number;
    }

}

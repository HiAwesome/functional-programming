package com.moqi.java.a02;

import fj.F;
import fj.data.List;

import static fj.data.List.range;

/**
 * 使用 Functional Java 框架实现的完美数分类
 *
 * @author moqi
 * On 3/15/20 09:56
 */
public class A0213NumberClassifierFunctionalJava {

    public List<Integer> factorsOf(final int number) {
        return range(1, number + 1)                                // <1>
                .filter(new F<Integer, Boolean>() {
                    public Boolean f(final Integer i) {
                        return number % i == 0;
                    }
                });                                                // <2>
    }
    // END functional_java_filter

    // Functional Java 提供的 foldLeft() 方法
    // BEGIN functional_java_fold
    public int aliquotSum(List<Integer> factors) {                // <3>
        return factors.foldLeft(fj.function.Integers.add, 0) - factors.last();
    }
    // END functional_java_fold

    public boolean isPerfect(int number) {
        return aliquotSum(factorsOf(number)) == number;
    }

    public boolean isAbundant(int number) {
        return aliquotSum(factorsOf(number)) > number;
    }

    public boolean isDeficient(int number) {
        return aliquotSum(factorsOf(number)) < number;
    }

}

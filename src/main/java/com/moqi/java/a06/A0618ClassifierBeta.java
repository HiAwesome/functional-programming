package com.moqi.java.a06;

import java.util.Iterator;

// 重构之后简化了的完美数分类程序
// BEGIN java_classifier_beta
public class A0618ClassifierBeta extends A0617FactorsBeta {

    public A0618ClassifierBeta(int number) {
        super(number);
    }

    public int sum() {
        Iterator it = getFactors().iterator();
        int sum = 0;
        while (it.hasNext())
            sum += (Integer) it.next();
        return sum;
    }

    public boolean isPerfect() {
        return sum() - number == number;
    }

    public boolean isAbundant() {
        return sum() - number > number;
    }

    public boolean isDeficient() {
        return sum() - number < number;
    }

}
// END java_classifier_beta

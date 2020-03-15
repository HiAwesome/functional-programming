package com.moqi.java.a06;

import java.util.HashSet;
import java.util.Set;

// 重构之后简化了的素数判定程序
// BEGIN java_prime_beta
public class A0619PrimeBeta extends A0617FactorsBeta {
    public A0619PrimeBeta(int number) {
        super(number);
    }

    public boolean isPrime() {
        Set<Integer> primeSet = new HashSet<Integer>() {{
            add(1);
            add(number);
        }};
        return getFactors().equals(primeSet);
    }

}
// END java_prime_beta

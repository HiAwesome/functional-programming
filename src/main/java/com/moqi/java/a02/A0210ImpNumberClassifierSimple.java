package com.moqi.java.a02;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 完美数分类的 Java 实现
 *
 * @author moqi
 * On 3/14/20 20:27
 */
public class A0210ImpNumberClassifierSimple {
    private final int _number;                          //<1>
    private final Map<Integer, Integer> _cache;         //<2>

    public A0210ImpNumberClassifierSimple(int targetNumber) {
        _number = targetNumber;
        _cache = new HashMap<>();
    }


    public boolean isFactor(int potential) {
        return _number % potential == 0;
    }

    public Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(_number);
        for (int i = 2; i < _number; i++)
            if (isFactor(i))
                factors.add(i);
        return factors;
    }

    public int aliquotSum() {                     // <3>
        if (_cache.get(_number) == null) {
            int sum = 0;
            for (int i : getFactors())
                sum += i;
            _cache.put(_number, sum - _number);
        }
        return _cache.get(_number);
    }

    public boolean isPerfect() {
        return aliquotSum() == _number;
    }

    public boolean isAbundant() {
        return aliquotSum() > _number;
    }

    public boolean isDeficient() {
        return aliquotSum() < _number;
    }
}
// END imp_classifier
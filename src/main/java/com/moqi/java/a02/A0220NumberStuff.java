package com.moqi.java.a02;

import fj.F2;
import fj.data.List;

/**
 * @author moqi
 * On 3/15/20 10:38
 */

public class A0220NumberStuff {

    // 按用户指定的条件执行 foldLeft()
    // BEGIN java_foldleft_criteria
    static public int addOnlyOddNumbersIn(List<Integer> numbers) {
        return numbers.foldLeft(new F2<Integer, Integer, Integer>() {
            public Integer f(Integer i1, Integer i2) {
                return (!(i2 % 2 == 0)) ? i1 + i2 : i1;
            }
        }, 0);
        // END java_foldleft_criteria
    }

}

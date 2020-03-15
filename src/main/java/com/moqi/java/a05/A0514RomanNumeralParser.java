package com.moqi.java.a05;

import fj.P1;

import java.util.HashMap;
import java.util.Map;

public class A0514RomanNumeralParser {
    // BEGIN java_romans_default
    private static final int MIN = 0;
    private static final int MAX = 1000;

    public static A0518Either<Exception, Integer> parseNumberDefaults(final String s) {
        if (!s.matches("[IVXLXCDM]+"))
            return A0518Either.left(new Exception("Invalid Roman numeral"));
        else {
            int number = new A0519RomanNumeral(s).toInt();
            return A0518Either.right(new A0519RomanNumeral(number >= MAX ? MAX : number).toInt());
        }
    }
    // END java_romans_default

    // BEGIN java_romans_parse
    public static A0518Either<Exception, Integer> parseNumber(String s) {
        if (!s.matches("[IVXLXCDM]+"))
            return A0518Either.left(new Exception("Invalid Roman numeral"));
        else
            return A0518Either.right(new A0519RomanNumeral(s).toInt());
    }
    // END java_romans_parse

    // 解析罗马数字
    // BEGIN java_romans_lazy
    public static P1<A0518Either<Exception, Integer>> parseNumberLazy(final String s) {
        if (!s.matches("[IVXLXCDM]+"))
            return new P1<A0518Either<Exception, Integer>>() {
                public A0518Either<Exception, Integer> _1() {
                    return A0518Either.left(new Exception("Invalid Roman numeral"));
                }
            };
        else
            return new P1<A0518Either<Exception, Integer>>() {
                public A0518Either<Exception, Integer> _1() {
                    return A0518Either.right(new A0519RomanNumeral(s).toInt());
                }
            };
    }
    // END java_romans_lazy


    // 利用 Map 来返回多个值
    // BEGIN java_romannum_divide
    public static Map<String, Object> divide(int x, int y) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (y == 0)
            result.put("exception", new Exception("div by zero"));
        else
            result.put("answer", (double) x / y);
        return result;
    }
    // END java_romannum_divide
}

package com.moqi.java.a05;

import fj.P1;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class A0515EitherTest {
    private static final String INVALID_ROMAN_NUMERAL = "Invalid Roman numeral";

    // 测试通过 Map 结构返回的成功结果和失败结果
    // BEGIN java_divide_test
    @Test
    public void maps_success() {
        Map<String, Object> result = A0514RomanNumeralParser.divide(4, 2);
        assertEquals(2.0, (Double) result.get("answer"), 0.1);
    }

    @Test
    public void maps_failure() {
        Map<String, Object> result = A0514RomanNumeralParser.divide(4, 0);
        assertEquals("div by zero", ((Exception) result.get("exception")).getMessage());
    }
    // END java_divide_test


    // BEGIN java_romans_parsing_test
    @Test
    public void parsing_success() {
        A0518Either<Exception, Integer> result = A0514RomanNumeralParser.parseNumber("XLII");
        assertEquals(Integer.valueOf(42), result.right());
    }

    @Test
    public void parsing_failure() {
        A0518Either<Exception, Integer> result = A0514RomanNumeralParser.parseNumber("FOO");
        assertEquals(INVALID_ROMAN_NUMERAL, result.left().getMessage());
    }
    // END java_romans_parsing_test

    // 测试基于 Functional Java 框架的缓求值解析器
    // BEGIN java_romans_parse_lazy_test
    @Test
    public void parse_lazy() {
        P1<A0518Either<Exception, Integer>> result =
                A0514RomanNumeralParser.parseNumberLazy("XLII");
        assertEquals(42, result._1().right().intValue());
    }

    @Test
    public void parse_lazy_exception() {
        P1<A0518Either<Exception, Integer>> result =
                A0514RomanNumeralParser.parseNumberLazy("FOO");
        assertTrue(result._1().isLeft());
        assertEquals(INVALID_ROMAN_NUMERAL, result._1().left().getMessage());
    }
    // END java_romans_parse_lazy_test

    // 测试默认值
    // BEGIN java_romans_defaults_test
    @Test
    public void parse_defaults_normal() {
        A0518Either<Exception, Integer> result =
                A0514RomanNumeralParser.parseNumberDefaults("XLII");
        assertEquals(42, result.right().intValue());
    }

    @Test
    public void parse_defaults_triggered() {
        A0518Either<Exception, Integer> result =
                A0514RomanNumeralParser.parseNumberDefaults("MM");
        assertEquals(1000, result.right().intValue());
    }
    // END java_romans_defaults_test
}

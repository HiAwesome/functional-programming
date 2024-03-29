package com.moqi.java.a05;

import fj.P1;
import fj.data.Either;
import fj.data.Option;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 测试罗马数字验证程序
 */
public class A0521FjEitherTest {
    private static final String INVALID_ROMAN_NUMERAL = "Invalid Roman numeral";

    @Test
    public void parsing_success() {
        Either<Exception, Integer> result = A0520FjRomanNumeralParser.parseNumber("XLII");
        assertEquals(Integer.valueOf(42), result.right().value());
    }

    @Test
    public void parsing_failure() {
        Either<Exception, Integer> result = A0520FjRomanNumeralParser.parseNumber("FOO");
        assertEquals(INVALID_ROMAN_NUMERAL, result.left().value().getMessage());
    }

    @Test
    public void parse_lazy() {
        P1<Either<Exception, Integer>> result = A0520FjRomanNumeralParser.parseNumberLazy("XLII");
        assertEquals((long) 42, (long) result._1().right().value());
    }

    @Test
    public void parse_lazy_exception() {
        P1<Either<Exception, Integer>> result = A0520FjRomanNumeralParser.parseNumberLazy("FOO");
        assertTrue(result._1().isLeft());
        assertEquals(INVALID_ROMAN_NUMERAL, result._1().left().value().getMessage());
    }

    @Test
    public void parse_defaults_normal() {
        Either<Exception, Integer> result = A0520FjRomanNumeralParser.parseNumberDefaults("XLII");
        assertEquals((long) 42, (long) result.right().value());
    }

    @Test
    public void parse_defaults_triggered() {
        Either<Exception, Integer> result = A0520FjRomanNumeralParser.parseNumberDefaults("MM");
        assertEquals((long) 1000, (long) result.right().value());
    }

    // 测试经 Either 包装的异常
    // BEGIN java_fj_divide_exception_test
    @Test
    public void catching_other_people_exceptions() {
        Either<Exception, Integer> result = A0520FjRomanNumeralParser.divide(4, 2);
        assertEquals((long) 2, (long) result.right().value());
        Either<Exception, Integer> failure = A0520FjRomanNumeralParser.divide(4, 0);
        assertEquals("/ by zero", failure.left().value().getMessage());
    }
    // END java_fj_divide_exception_test

    // 处理经缓求值包装的异常
    // BEGIN java_fj_divide_lazy_exception_test
    @Test
    public void lazily_catching_other_peoples_exceptions() {
        P1<Either<Exception, Integer>> result = A0520FjRomanNumeralParser.divideLazily(4, 2);
        assertEquals((long) 2, (long) result._1().right().value());
        P1<Either<Exception, Integer>> failure = A0520FjRomanNumeralParser.divideLazily(4, 0);
        assertEquals("/ by zero", failure._1().left().value().getMessage());
    }
    // END java_fj_divide_lazy_exception_test

    // BEGIN java_fj_nested_exception_test
    private P1<Either<Exception, Double>> divide(final double x, final double y) {
        return new P1<Either<Exception, Double>>() {
            public Either<Exception, Double> _1() {
                try {
                    return Either.right(x / y);
                } catch (Exception e) {
                    return Either.left(e);
                }
            }
        };
    }

    @Test
    public void test_divide_romans_success() {
        Either<NumberFormatException, Either<ArithmeticException, Double>> result = A0520FjRomanNumeralParser.divideRoman("IV", "II");
        assertEquals(2.0, result.right().value().right().value().doubleValue(), 0.1);
    }

    @Test
    public void test_divide_romans_number_format_error() {
        Either<NumberFormatException, Either<ArithmeticException, Double>> result = A0520FjRomanNumeralParser.divideRoman("IVooo", "II");
        assertEquals("invalid parameter", result.left().value().getMessage());
    }

    @Test
    public void test_divide_romans_arthmetic_exception() {
        Either<NumberFormatException, Either<ArithmeticException, Double>> result = A0520FjRomanNumeralParser.divideRoman("IV", "I");
        assertEquals("div by 1", result.right().value().left().value().getMessage());
    }

    // END java_fj_nested_exception_test
    //
    //    @Ignore("can't get final assertion to work because of type system wonkery")
    //    @Test
    //    public void lift_other_functions() {
    //        F<Double, Double> sin = new F<Double, Double>() {
    //                public Double f(final Double a) {
    //                    return Math.sin(a);
    //                }
    //            };
    ////        P1<A0518Either<Exception, Double>> lifter = divide(4, 2).map(A0518Either.rightMap_().f(sin));
    //    }


    // 测试 Option 的行为
    // BEGIN java_fj_option_test
    @Test
    public void option_test_success() {
        Option result = A0520FjRomanNumeralParser.divide(4.0, 2);
        assertEquals(2.0, (Double) result.some(), 0.1);
    }

    @Test
    public void option_test_failure() {
        Option result = A0520FjRomanNumeralParser.divide(4.0, 0);
        assertEquals(Option.none(), result);
    }
    // END java_fj_option_test


}

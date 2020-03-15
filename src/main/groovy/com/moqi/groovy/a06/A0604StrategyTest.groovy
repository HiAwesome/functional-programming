package com.moqi.groovy.a06

import org.junit.Test

// 用 Strategy 模式来处理两个数字的积的计算问题
// BEGIN groovy_calc
interface Calc {
    def product(n, m)
}

class CalcMulti implements Calc {
    def product(n, m) { n * m }
}

class CalcAdds implements Calc {
    def product(n, m) {
        def result = 0
        n.times {
            result += m
        }
        result
    }
}
// END groovy_calc

// BEGIN groovy_strategy_test
class StrategyTest {
    def listOfStrategies = [new CalcMulti(), new CalcAdds()]

    @Test
    public void product_verifier() {
        listOfStrategies.each { s ->
            GroovyTestCase.assertEquals(10, s.product(5, 2))
        }
    }
	// END groovy_strategy_test  

	// BEGIN groovy_functional_strategy
    @Test
    public void exp_verifier() {
        def listOfExp = [
                { i, j -> Math.pow(i, j) },
                { i, j ->
                    def result = i
                    (j - 1).times { result *= i }
                    result
                }]

        listOfExp.each { e ->
            GroovyTestCase.assertEquals(32, e(2, 5))
            GroovyTestCase.assertEquals(100, e(10, 2))
            GroovyTestCase.assertEquals(1000, e(10, 3))
        }
    }
	// END groovy_functional_strategy  
}


  

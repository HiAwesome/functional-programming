package com.moqi.groovy.a02

import static java.lang.Math.round
import static java.lang.Math.sqrt

/**
 * @author moqi* On 3/15/20 10:26
 */
class A0217NumberClassifierOpt {
    // Groovy 版的约数查找优化算法
    // BEGIN groovy_mapping
    static def factors(number) {
        def factors = (1..round(sqrt(number) + 1)).findAll({ number % it == 0 })
        (factors + factors.collect { number / it }).unique()
    }
    // END groovy_mapping

    static def sumFactors(number) {
        factors(number).inject(0, { i, j -> i + j })
    }

    static def isPerfect(number) {
        sumFactors(number) - number == number
    }

    static def isAbundant(number) {
        sumFactors(number) - number > number
    }

    static def isDeficient(number) {
        sumFactors(number) - number < number
    }
}

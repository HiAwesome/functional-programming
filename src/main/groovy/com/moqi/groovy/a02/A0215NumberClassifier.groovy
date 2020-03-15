package com.moqi.groovy.a02

/**
 * @author moqi* On 3/15/20 10:24
 */
class A0215NumberClassifier {
    // Groovy 的筛选操作（叫作 findAll() ）
    // BEGIN groovy_filter
    static def factors(number) {
        (1..number).findAll { number % it == 0 }
    }
    // END groovy_filter

    // Groovy 版的 reduce 叫做 inject
    // BEGIN groovy_reduce
    static def sumFactors(number) {
        factors(number).inject(0, { i, j -> i + j })
    }
    // END groovy_reduce

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

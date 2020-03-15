package com.moqi.groovy.a08

import fj.data.Stream
import junit.framework.Assert
import org.junit.Test

import static fj.data.Stream.cons

/**
 * 目前不能运行
 * (probably) Copyright 2011 by Neal Ford. All rights reserved.
 */
class A0802IntegerClassifierTest {
    // 通过元编程使 Integer 具备完美数分类能力
    static {
        Integer.metaClass.isPerfect = { ->
            Classifier.isPerfect(delegate)
        }

        Integer.metaClass.isAbundant = { ->
            Classifier.isAbundant(delegate)
        }

        Integer.metaClass.isDeficient = { ->
            Classifier.isDeficient(delegate)
        }
    }

    @Test
    void classifier_classifies_correctly() {
        Assert.assertTrue Classifier.isPerfect(6)
        Assert.assertTrue Classifier.isPerfect(496)
        Assert.assertTrue Classifier.isDeficient(7)
        Assert.assertTrue Classifier.isAbundant(12)
    }

    @Test
    void metaclass_classifiers() {
        def num = 28
        Assert.assertTrue num.isPerfect()
        Assert.assertTrue 7.isDeficient()
        Assert.assertTrue 6.isPerfect()
        Assert.assertTrue 12.isAbundant()
    }

    @Test
    void curry_to_create_classifier() {
        def perfect6 = Classifier.&isPerfect.curry(6)
        def deficient6 = Classifier.&isDeficient.curry(6)
        Assert.assertTrue perfect6()
        org.junit.Assert.assertFalse deficient6()
    }

    // 通过元编程将 Functional Java 的类映射成集合
    // BEGIN groovy_metafunctional_stream
    static {
        Stream.metaClass.filter = { c -> delegate.filter(c as fj.F) }
        //    Stream.metaClass.filter = { Closure c -> delegate.filter(c as fj.F) }
        Stream.metaClass.getAt = { n -> delegate.index(n) }
        Stream.metaClass.getAt = { Range r -> r.collect { delegate.index(it) } }
    }

    @Test
    void adding_methods_to_fj_classes() {
        def evens = Stream.range(0).filter { it % 2 == 0 }
        Assert.assertTrue(evens.take(5).asList() == [0, 2, 4, 6, 8])
        Assert.assertTrue((8..12).collect { evens[it] } == [16, 18, 20, 22, 24])
        Assert.assertTrue(evens[3..6] == [6, 8, 10, 12])
    }
    // END groovy_metafunctional_stream

    @Test
    void next_perfect_number() {
        Assert.assertTrue Classifier.nextPerfectNumberAfter(1) == 6
        Assert.assertTrue Classifier.nextPerfectNumberAfter(6) == 28
        Assert.assertTrue Classifier.nextPerfectNumberAfter(28) == 496
    }

    // 实现完美数序列需要改造的两个方法
    // BEGIN groovy_add_fj_list
    static {
        Stream.metaClass.asList = { delegate.toCollection().asList() }
        //    Stream.metaClass.static.cons = 
        //      { head, Closure c -> delegate.cons(head, ['_1':c] as fj.P1)}
        Stream.metaClass.static.cons =
                { head, closure -> delegate.cons(head, closure as fj.P1) }
    }
    // END groovy_add_fj_list
    // BEGIN groovy_fj_infinite_perfect
    def perfectNumbers(num) {
        cons(nextPerfectNumberAfter(num), { perfectNumbers(nextPerfectNumberAfter(num)) })
    }

    // 由 Functional Java 和 Groovy 共同构造的无限长完美数序列
    @Test
    void infinite_stream_of_perfect_nums_using_funtional_java() {
        org.junit.Assert.assertEquals([6, 28, 496], perfectNumbers(1).take(3).asList())
    }
    // END groovy_fj_infinite_perfect

}

package com.moqi.groovy.a04

import junit.framework.Assert
import org.junit.Test

/**
 * (probably) Copyright 2011 by Neal Ford. All rights reserved.
 */
class A0402ClassifierTest {
    def classifier = new A0401ClassifierCachedSum()
    def start;

    @Test
    void classifies_correctly() {
        Assert.assertTrue(Classifier.isPerfect(6))
        Assert.assertTrue(Classifier.isPerfect(496))
        Assert.assertTrue(Classifier.isPerfect(8128))
        Assert.assertTrue(Classifier.isAbundant(24))
        Assert.assertTrue(Classifier.isDeficient(7))
    }

    @Test
    void optimizations() {
        Assert.assertTrue(ClassifierFast.isPerfect(6))
        Assert.assertTrue(ClassifierFast.isPerfect(496))
        Assert.assertTrue(ClassifierFast.isPerfect(8128))
        Assert.assertTrue(ClassifierFast.isAbundant(24))
        Assert.assertTrue(ClassifierFast.isDeficient(16))
        Assert.assertTrue(ClassifierFast.isDeficient(7))

    }

// BEGIN groovy_uncached_sum
    def static final TEST_NUMBER_MAX = 5000

    @Test
    void mashup() {
        println "Test for range 1-${TEST_NUMBER_MAX}"
        print "Non-optimized:              "
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (Classifier.isPerfect(n)) print '!'
            else if (Classifier.isAbundant(n)) print '+'
            else if (Classifier.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
        print "Non-optimized (2nd):        "
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (Classifier.isPerfect(n)) print '!'
            else if (Classifier.isAbundant(n)) print '+'
            else if (Classifier.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
// END groovy_uncached_sum

// BEGIN groovy_cached_sum
        print "Cached sum:                 "
        def start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (classifier.isPerfect(n)) print '!'
            else if (classifier.isAbundant(n)) print '+'
            else if (classifier.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
        print "Cached sum (2nd run):       "
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (classifier.isPerfect(n)) print '!'
            else if (classifier.isAbundant(n)) print '+'
            else if (classifier.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
// END groovy_cached_sum

// BEGIN groovy_cached_fully
        print "Cached:                     "
        def classifierFullyCached = new A0400ClassifierCached()
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (classifierFullyCached.isPerfect(n)) print '!'
            else if (classifierFullyCached.isAbundant(n)) print '+'
            else if (classifierFullyCached.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
        print "Cached (2nd run):           "
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (classifierFullyCached.isPerfect(n)) print '!'
            else if (classifierFullyCached.isAbundant(n)) print '+'
            else if (classifierFullyCached.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
// END groovy_cached_fully

// BEGIN groovy_partially_memoized
        print "Partially Memoized:         "
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (ClassifierMemoizedSum.isPerfect(n)) print '!'
            else if (ClassifierMemoizedSum.isAbundant(n)) print '+'
            else if (ClassifierMemoizedSum.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
        print "Partially Memoized (2nd):   "
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (ClassifierMemoizedSum.isPerfect(n)) print '!'
            else if (ClassifierMemoizedSum.isAbundant(n)) print '+'
            else if (ClassifierMemoizedSum.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"

        print "Memoized:                   "
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (ClassifierMemoized.isPerfect(n)) print '!'
            else if (ClassifierMemoized.isAbundant(n)) print '+'
            else if (ClassifierMemoized.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
        print "Memoized(2nd)               "
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (ClassifierMemoized.isPerfect(n)) print '!'
            else if (ClassifierMemoized.isAbundant(n)) print '+'
            else if (ClassifierMemoized.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
// END groovy_partially_memoized
    }

}

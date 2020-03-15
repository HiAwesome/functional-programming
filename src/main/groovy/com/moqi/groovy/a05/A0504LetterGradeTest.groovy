package com.moqi.groovy.a05

import org.junit.Assert
import org.junit.Test

// 测试 Groovy 版的成绩分等程序
class A0504LetterGradeTest {
    @Test
    void test_letter_grades() {
        def lg = new A0503LetterGrade()
        Assert.assertEquals("A", lg.gradeFromScore(92))
        Assert.assertEquals("B", lg.gradeFromScore(85))
        Assert.assertEquals("D", lg.gradeFromScore(65))
        Assert.assertEquals("F", lg.gradeFromScore("f"))
    }
}

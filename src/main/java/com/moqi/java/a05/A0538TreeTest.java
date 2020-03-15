package com.moqi.java.a05;

import org.junit.Test;

import static com.moqi.java.a05.A0535Tree.*;
import static com.moqi.java.a05.A0536Trees.*;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * 测试树的搜索
 * (probably) Copyright 2012 by Neal Ford. All rights reserved.
 */
public class A0538TreeTest {

    @Test
    public void depth_of_0_test() {
        A0535Tree t = new Empty();
        assertEquals(0, depth(t));
    }

    @Test
    public void depth_of_1_test() {
        A0535Tree t = new Node(new Empty(), new Empty());
        assertEquals(1, depth(t));
    }

    @Test
    public void depth_of_3_test() {
        A0535Tree t = new Node(new Empty(), new Node(new Leaf(5), new Empty()));
        assertEquals(3, depth(t));
    }

    @Test
    public void depth_of_4_test() {
        A0535Tree t = new Node(new Empty(), new Node(new Empty(), new Node(new Empty(), new Leaf(4))));
        assertEquals(4, depth(t));
    }

    @Test
    public void depth_of_5_with_hetero_tree_test() {
        A0535Tree t = new Node(
                new Node(
                        new Node(
                                new Node(
                                        new Node(new Leaf(4), new Empty()), new Leaf(12)), new Leaf(55)), new Empty()), new Leaf(4));
        assertEquals(6, depth(t));
    }

    @Test
    public void different_structure() {
        A0535Tree t = new Node(new Leaf(5), new Empty());
        assertEquals(2, depth(t));
    }

    @Test
    public void search_test() {
        A0535Tree t = new Node(new Empty(), new Leaf(4));
        assertEquals(1, occurrencesIn(t, 4));
        assertEquals(0, occurrencesIn(t, 32));
    }

    @Test
    public void more_elaborate_search_test() {
        A0535Tree t = new Node(new Node(new Node(new Node(
                new Node(new Leaf(4), new Empty()),
                new Leaf(12)), new Leaf(55)),
                new Empty()), new Leaf(4));
        assertEquals(1, occurrencesIn(t, 55));
        assertEquals(2, occurrencesIn(t, 4));
        assertEquals(1, occurrencesIn(t, 12));
        assertEquals(0, occurrencesIn(t, 42));
    }

    @Test
    public void boolean_search_test() {
        A0535Tree t = new Node(new Empty(), new Leaf(4));
        assertTrue(inTree(t, 4));
        assertFalse(inTree(t, 42));
    }


    // BEGIN java_eithertrees_search_test
    @Test
    public void more_elaborate_searchp_test() {
        A0535Tree t = new Node(new Node(new Node(new Node(
                new Node(new Leaf(4), new Empty()),
                new Leaf(12)), new Leaf(55)),
                new Empty()), new Leaf(4));
        assertTrue(inTree(t, 55));
        assertTrue(inTree(t, 4));
        assertTrue(inTree(t, 12));
        assertFalse(inTree(t, 42));
    }
    // END java_eithertrees_search_test

    // 在一棵复杂的树上获取深度、查找元素和计算元素的重复次数
    // BEGIN java_eithertrees_branch_test
    @Test
    public void multi_branch_tree_test() {
        A0535Tree t = new Node(new Node(new Node(new Leaf(4),
                new Node(new Leaf(1), new Node(
                        new Node(new Node(new Node(
                                new Node(new Node(new Leaf(10), new Leaf(0)),
                                        new Leaf(22)), new Node(new Node(
                                new Node(new Leaf(4), new Empty()),
                                new Leaf(101)), new Leaf(555))),
                                new Leaf(201)), new Leaf(1000)),
                        new Leaf(4)))),
                new Leaf(12)), new Leaf(27));
        assertEquals(12, depth(t));
        assertTrue(inTree(t, 555));
        assertEquals(3, occurrencesIn(t, 4));
    }
    // END java_eithertrees_branch_test
}

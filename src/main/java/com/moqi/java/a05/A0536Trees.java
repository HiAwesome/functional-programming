package com.moqi.java.a05;

import fj.data.Either;

import static com.moqi.java.a05.A0535Tree.*;
import static java.lang.Math.max;

public class A0536Trees {

    // 模仿模式匹配的语法来获取树的深度
    // BEGIN java_eithertree_depth
    static public int depth(A0535Tree t) {
        for (A0535Tree.Empty e : t.toEither().left())
            return 0;
        for (Either<Leaf, Node> ln : t.toEither().right()) {
            for (Leaf leaf : ln.left())
                return 1;
            for (Node node : ln.right())
                return 1 + max(depth(node.left), depth(node.right));
        }
        throw new RuntimeException("Inexhaustible pattern match on A0535Tree");
    }
    // END java_eithertree_depth

    // 判断给定值在树中是否存在
    // BEGIN java_eithertree_intree
    static public boolean inTree(A0535Tree t, int value) {
        for (Empty e : t.toEither().left())
            return false;
        for (Either<Leaf, Node> ln : t.toEither().right()) {
            for (Leaf leaf : ln.left())
                return value == leaf.n;
            for (Node node : ln.right())
                return inTree(node.left, value) | inTree(node.right, value);
        }
        return false;
    }
    // END java_eithertree_intree

    // 计算元素在树中的重复次数
    // BEGIN java_eithertree_occurrences
    static public int occurrencesIn(A0535Tree t, int value) {
        for (Empty e : t.toEither().left())
            return 0;
        for (Either<Leaf, Node> ln : t.toEither().right()) {
            for (Leaf leaf : ln.left())
                if (value == leaf.n) return 1;
            for (Node node : ln.right())
                return occurrencesIn(node.left, value)
                        + occurrencesIn(node.right, value);
        }
        return 0;
    }
    // END java_eithertree_occurrences

    static public String printTree(A0535Tree t, String output) {
        for (Empty e : t.toEither().left())
            return output;
        for (Either<Leaf, Node> ln : t.toEither().right()) {
            for (Leaf leaf : ln.left())
                return output + String.valueOf(leaf.n) + "\n";
            for (Node node : ln.right())
                return "." + printTree(node.left, output) + printTree(node.right, output);
        }
        return "";
    }

    public static void main(String[] args) {
        A0535Tree t = new Node(new Node(new Node(new Leaf(4), new Node(new Leaf(1), new Node(new Node(new Node(new Node(
                new Node(new Node(new Leaf(10), new Leaf(0)), new Leaf(22)), new Node(new Node(new Node(new Leaf(4),
                new Empty()), new Leaf(101)), new Leaf(555))), new Leaf(201)), new Leaf(1000)), new Leaf(4)))),
                new Leaf(12)), new Leaf(27));
        System.out.println(printTree(t, ""));
    }


}

package com.moqi.java.a05;

import fj.F;

// 通过 A0518Either 类（类型安全地）返回两种值
public class A0518Either<A, B> {
    private A left = null;
    private B right = null;

    private A0518Either(A a, B b) {
        left = a;
        right = b;
    }

    public static <A, B> A0518Either<A, B> left(A a) {
        return new A0518Either<A, B>(a, null);
    }

    public static <A, B> A0518Either<A, B> right(B b) {
        return new A0518Either<A, B>(null, b);
    }

    public A left() {
        return left;
    }

    public boolean isLeft() {
        return left != null;
    }

    public boolean isRight() {
        return right != null;
    }

    public B right() {
        return right;
    }

    public void fold(F<A, B> leftOption, F<B, A> rightOption) {
        if (right == null)
            leftOption.f(left);
        else
            rightOption.f(right);
    }
}
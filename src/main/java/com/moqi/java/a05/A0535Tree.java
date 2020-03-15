package com.moqi.java.a05;

import fj.data.Either;

import static fj.data.Either.left;
import static fj.data.Either.right;

/**
 * 在 Either 上建立起来的树结构
 */
public abstract class A0535Tree {
    private A0535Tree() {
    }

    public abstract Either<Empty, Either<Leaf, Node>> toEither();

    public static final class Empty extends A0535Tree {
        public Empty() {
        }

        public Either<Empty, Either<Leaf, Node>> toEither() {
            return left(this);
        }
    }

    public static final class Leaf extends A0535Tree {
        public final int n;

        public Leaf(int n) {
            this.n = n;
        }

        @Override
        public Either<Empty, Either<Leaf, Node>> toEither() {
            return right(Either.<Leaf, Node>left(this));
        }
    }

    public static final class Node extends A0535Tree {
        public final A0535Tree left;
        public final A0535Tree right;

        public Node(A0535Tree left, A0535Tree right) {
            this.left = left;
            this.right = right;
        }

        public Either<Empty, Either<Leaf, Node>> toEither() {
            return right(Either.<Leaf, Node>right(this));
        }
    }

}

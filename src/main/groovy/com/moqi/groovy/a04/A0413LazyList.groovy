package com.moqi.groovy.a04

class A0413LazyList {
    private head, tail

    A0413LazyList(head, tail) {
        this.head = head;
        this.tail = tail
    }

    def A0413LazyList getTail() { tail ? tail() : null }

    def List getHead(n) {
        def harvestedValues = [];
        def current = this
        n.times {
            harvestedValues << current.head
            current = current.tail
        }
        harvestedValues
    }

    def A0413LazyList filter(Closure p) {
        if (p(head))
            p.owner.prepend(head, { getTail().filter(p) })
        else
            getTail().filter(p)
    }
}
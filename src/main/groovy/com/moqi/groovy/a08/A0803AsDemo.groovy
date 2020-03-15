package com.moqi.groovy.a08

h = [hasNext: { h.i > 0 }, next: { h.i-- }]
h.i = 10   // <1>
// 利用 Groovy 的 as 运算符将 map 结构强行映射成特定接口的实现
def pseudoIterator = h as Iterator   // <2>

while (pseudoIterator.hasNext())
    print pseudoIterator.next() + (pseudoIterator.hasNext() ? ", " : "\n")
// 10, 9, 8, 7, 6, 5, 4, 3, 2, 1,

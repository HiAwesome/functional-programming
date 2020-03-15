package com.moqi.groovy.a03

class A0406NameHash {
    //  内联声明函数的记忆能力，Groovy 实现
    def static hash = { name ->
        name.collect { rot13(it) }.join()
    }.memoize()

    public static char rot13(s) {
        char c = s
        switch (c) {
            case 'A'..'M':
            case 'a'..'m': return c + 13
            case 'N'..'Z':
            case 'n'..'z': return c - 13
            default: return c
        }
    }

}

package com.moqi.groovy.a03

/**
 * 测试被记忆的散列函数
 *
 * @author moqi* On 3/15/20 13:09
 */
class A0407NameHashTest extends GroovyTestCase {
    void testHash() { assertEquals("ubzre", A0406NameHash.hash.call("homer")) }
}
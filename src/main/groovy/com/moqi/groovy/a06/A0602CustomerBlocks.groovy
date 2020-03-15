package com.moqi.groovy.a06

// 第一等函数对 Template Method 模式的影响
class A0602CustomerBlocks {
    def plan, checkCredit, checkInventory, ship

    A0602CustomerBlocks() {
        plan = []
    }

    def process() {
        checkCredit()
        checkInventory()
        ship()
    }
}
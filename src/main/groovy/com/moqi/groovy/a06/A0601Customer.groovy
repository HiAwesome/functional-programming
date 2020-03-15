package com.moqi.groovy.a06;

// Template Method 模式的“标准”实现
abstract class A0601Customer {
    def plan

    def A0601Customer() {
        plan = []
    }

    def abstract checkCredit()

    def abstract checkInventory()

    def abstract ship()

    def process() {
        checkCredit()
        checkInventory()
        ship()
    }
}
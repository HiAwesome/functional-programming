package com.moqi.groovy.a06

// 为调用代码块增加防护
class A0603CustomerBlocksWithProtection {
    def plan, checkCredit, checkInventory, ship

    A0603CustomerBlocksWithProtection() {
        plan = []
    }
    // BEGIN groovy_customer_blocks
    def process() {
        checkCredit?.call()
        checkInventory?.call()
        ship?.call()
    }
    // END groovy_customer_blocks
}
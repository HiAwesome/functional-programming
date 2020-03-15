package com.moqi.groovy.a06

import org.junit.Test

// BEGIN groovy_flyweight_defs
class Computer {
    def type
    def cpu
    def memory
    def hardDrive
    def cd
}

class Desktop extends Computer {
    def driveBays
    def fanWattage
    def videoCard
}

class Laptop extends Computer {
    def usbPorts
    def dockingBay
}

class AssignedComputer {
    def computerType
    def userId

    AssignedComputer(computerType, userId) {
        this.computerType = computerType
        this.userId = userId
    }
}
// END groovy_flyweight_defs

// 生产 flyweight 计算机实例的单例工厂
// BEGIN groovy_computer_factory
class CompFactory {
    def types = [:]
    static def instance

    private ComputerFactory() {
        def laptop = new Laptop()
        def tower = new Desktop()
        types.put("MacBookPro6_2", laptop)
        types.put("SunTower", tower)
    }

    static def getInstance() {
        if (instance == null)
            instance = new CompFactory()
        instance
    }

    def ofType(computer) {
        types[computer]
    }
}
// END groovy_computer_factory

// 简化的单例工厂
// BEGIN groovy_factory_singleton
@Singleton(strict = false)
class ComputerFactory {
    def types = [:]

    private ComputerFactory() {
        def laptop = new Laptop()
        def tower = new Desktop()
        types.put("MacBookPro6_2", laptop)
        types.put("SunTower", tower)
    }

    def ofType(computer) {
        types[computer]
    }
}
// END groovy_factory_singleton

// 这里两个方法名需要加 test 前缀
class FlyweightTest extends GroovyTestCase {
    // 把共享内容记忆起来
    // BEGIN groovy_memoization_of_flyweights
    def computerOf = { type ->
        def of = [MacBookPro6_2: new Laptop(), SunTower: new Desktop()]
        return of[type]
    }

    def computerOfType = computerOf.memoize()
    // END groovy_memoization_of_flyweights

    // 证明工厂返回的是标准品
    // BEGIN groovy_flyweight_test
    @Test
    void test_comp_factory() {
        def bob = new AssignedComputer(
                CompFactory.instance.ofType("MacBookPro6_2"), "Bob")
        def steve = new AssignedComputer(
                CompFactory.instance.ofType("MacBookPro6_2"), "Steve")
        assertTrue(bob.computerType == steve.computerType)
    }
    // END groovy_flyweight_test

    // 两种实现方式的比较
    // BEGIN groovy_flyweight_demo
    @Test
    void test_flyweight_computers() {
        def bob = new AssignedComputer(
                ComputerFactory.instance.ofType("MacBookPro6_2"), "Bob")
        def steve = new AssignedComputer(
                ComputerFactory.instance.ofType("MacBookPro6_2"), "Steve")
        assertTrue(bob.computerType == steve.computerType)

        def sally = new AssignedComputer(
                computerOfType("MacBookPro6_2"), "Sally")
        def betty = new AssignedComputer(
                computerOfType("MacBookPro6_2"), "Betty")
        assertTrue sally.computerType == betty.computerType
    }
    // END groovy_flyweight_demo
}

package com.moqi.scala.a05

import org.scalatest.funsuite.AnyFunSuite

class A0513ComplexTest extends AnyFunSuite {

  def fixture =
    new {
      val a = new A0512Complex(1, 2)
      val b = new A0512Complex(30, 40)
    }

  test("plus") {
    val f = fixture
    val z = f.a + f.b
    assert(1 + 30 == z.real)
  }

  test("comparison") {
    val f = fixture
    assert(f.a < f.b)
    assert(new A0512Complex(1, 2) >= new A0512Complex(3, 4))
    assert(new A0512Complex(1, 1) < new A0512Complex(2,2))
    assert(new A0512Complex(-10, -10) > new A0512Complex(1, 1))
    assert(new A0512Complex(1, 2) >= new A0512Complex(1, 2))
    assert(new A0512Complex(1, 2) <= new A0512Complex(1, 2))
  }

}
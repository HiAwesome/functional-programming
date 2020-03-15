package com.moqi.groovy.a05

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class A0511ComplexNumberTest {
  def x, y

  @Before void setup() {
    x = new A0510ComplexNumber(3, 2)
    y = new A0510ComplexNumber(1, 4)
  }

  @Test void plus() {
    def z = x + y;
      Assert.assertTrue 3 + 1 == z.real
      Assert.assertTrue 2 + 4 == z.imaginary
  }
  
  @Test void multiply() {
    def z = x * y
      Assert.assertTrue(-5  == z.real)
      Assert.assertTrue 14 == z.imaginary
  }

  @Test void to_string() {
    Assert.assertTrue "3+2i" == x.toString()
      Assert.assertTrue "4+6i" == (x + y).toString()
      Assert.assertTrue "3+0i" == new A0510ComplexNumber(3, 0).toString()
      Assert.assertTrue "4-2i" == new A0510ComplexNumber(4, -2).toString()
  }
}

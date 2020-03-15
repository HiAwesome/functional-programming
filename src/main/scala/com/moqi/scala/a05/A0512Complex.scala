package com.moqi.scala.a05

// Scala 版的复数模型
final class A0512Complex(val real: Int, val imaginary: Int) extends Ordered[A0512Complex] {

  def +(operand: A0512Complex) =
      new A0512Complex(real + operand.real, imaginary + operand.imaginary)

  def +(operand: Int) =
    new A0512Complex(real + operand, imaginary)

  def -(operand: A0512Complex) =
    new A0512Complex(real - operand.real, imaginary - operand.imaginary)

  def -(operand: Int) =
    new A0512Complex(real - operand, imaginary)

  def *(operand: A0512Complex) =
      new A0512Complex(real * operand.real - imaginary * operand.imaginary,
          real * operand.imaginary + imaginary * operand.real)

  override def toString() =
      real + (if (imaginary < 0) "" else "+") + imaginary + "i"

  override def equals(that: Any) = that match {
    case other : A0512Complex => (real == other.real) && (imaginary == other.imaginary)
    case other : Int => (real == other) && (imaginary == 0)
    case _ => false
  }

  override def hashCode(): Int =
    41 * ((41 + real) + imaginary)

  def compare(that: A0512Complex) : Int = {
    def myMagnitude = Math.sqrt(real ^ 2 + imaginary ^ 2)
    def thatMagnitude = Math.sqrt(that.real ^ 2 + that.imaginary ^ 2)
    (myMagnitude - thatMagnitude).round.toInt
  }
}
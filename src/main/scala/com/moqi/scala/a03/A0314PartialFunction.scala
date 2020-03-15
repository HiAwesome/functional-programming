package com.moqi.scala.a03

object A0314PartialFunction extends App {

  val answerUnits = new PartialFunction[Int, Int] {
    def apply(d: Int) = 42 / d

    def isDefinedAt(d: Int) = d != 0
  }

  assert(answerUnits.isDefinedAt(42));
  assert (!answerUnits.isDefinedAt(0));
  assert (answerUnits(42) == 1);
  //answerUnits(0)
  // java.lang.ArithmeticException: / by zero
}
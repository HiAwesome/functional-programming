package com.moqi.scala.a03

object A0316IncFunction extends App {

  def inc: PartialFunction[Any, Int] = {
    case i: Int => i + 1
  }

  assert(inc(41) == 42)
  assert(inc.isDefinedAt(41));
  //inc("Forty-one") //scala.MatchError: Forty-one (of class java.lang.String)
  assert (!inc.isDefinedAt("Forty-one"))

  assert(List(42) == (List(41, "cat") collect inc))
}
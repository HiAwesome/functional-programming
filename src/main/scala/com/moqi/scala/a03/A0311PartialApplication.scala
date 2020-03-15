package com.moqi.scala.a03

object A0311PartialApplication extends App {

  val locallyTaxed = withTax(_: Double, "NY")
  val costOfApples = locallyTaxed(price("apples"))

  // Scala 语言中函数的部分施用
  def price(product: String): Double = product match {
    case "apples" => 140
    case "oranges" => 223
  }

  def withTax(cost: Double, state: String): Double = state match {
    case "NY" => cost * 2
    case "FL" => cost * 3
  }

  assert(Math.round(costOfApples) == 280)
}
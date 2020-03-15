package com.moqi.scala.a03

object A0310CurryTest extends App {

  // Scala 语言中的参数柯里化
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)

  // 递归式的函数筛选，Scala 实现
  def dividesBy(n: Int)(x: Int) = ((x % n) == 0) // <1>

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
  println(filter(nums, dividesBy(2)))  // <2>
  println(filter(nums, dividesBy(3)))
}
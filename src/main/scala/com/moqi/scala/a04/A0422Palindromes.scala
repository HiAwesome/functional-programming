package com.moqi.scala.a04

object A0422Palindromes extends App {

  def findPalindrome(s: Seq[String]) = s find isPalindrome

  // 查找回文词，Scala 实现
  def isPalindrome(x: String) = x == x.reverse

}





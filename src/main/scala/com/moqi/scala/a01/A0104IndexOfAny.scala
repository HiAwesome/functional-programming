package com.moqi.scala.a01

/**
 * @author moqi
 *         On 3/13/20 22:05
 */
object A0104IndexOfAny {

  def main(args: Array[String]): Unit = {
    println("boundary conditions\n================")
    println(firstIndexOfAny("", "") match { case Some(matches) => "matches"; case None => "No values present" }, "expected No values present")
    println(firstIndexOfAny("", "a") match { case Some(matches) => "matches"; case None => "No values present" }, "expected No values present")
    println(firstIndexOfAny("z", "") match { case Some(matches) => "matches"; case None => "No values present" }, "expected No values present")
    println(firstIndexOfAny("aba", "z") match { case Some(matches) => "matches"; case None => "No values present" }, "expected No values present")

    println("\nfirstIndexOfAny tests\n================")
    println(firstIndexOfAny("zzabyycdxx", "za").get, "expected: 0")
    println(firstIndexOfAny("zzabyycdxx", "by").get, "expected: 3")
    println(firstIndexOfAny("zzyabyycdxx", "by").get, "expected: 2")


    println("\nindexOfAny tests\n================")

    println(indexOfAny("zzabyycdxx", ""), "expected: []")
    println(indexOfAny("", "za"), "expected: []")
    println(indexOfAny("", ""), "expected: []")
    println(indexOfAny("zzabyycdxx", "za"), "expected: [0 1 2]")
    println(indexOfAny("zzabyycdxx", "by"), "expected: [3 4 5]")
    println(indexOfAny("zzabyycdxx", "ax"), "expected: [2 8 9]")
    println(indexOfAny("zxzabyycdx", "ax"), "expected: [1 3 9]")

    println("\nindexed collection\n================")
    println(indexedInput("zabycdxx"))
  }

  /**
   * Scala 实现的 firstIndexOfAny()
   */
  def firstIndexOfAny(input: String, searchChars: Seq[Char]): Option[Int] = {
    def indexedInput = (0 until input.length).zip(input)

    val result = for (pair <- indexedInput;
                      char <- searchChars;
                      if (char == pair._2)) yield (pair._1)
    //noinspection HeadOrLastOption
    if (result.isEmpty)
      None
    else
      Some(result.head)
  }

  /**
   * 返回匹配项的一个缓求值列表
   */
  def indexOfAny(input: String, searchChars: Seq[Char]): Seq[Int] = {
    def indexedInput = (0 until input.length).zip(input)

    for (pair <- indexedInput;
         char <- searchChars;
         if (char == pair._2)) yield (pair._1)
  }

  def indexedInput(input: Seq[Char]): Seq[Any] = {
    //noinspection RangeToIndices
    (0 until input.length).zip(input)
  }

}

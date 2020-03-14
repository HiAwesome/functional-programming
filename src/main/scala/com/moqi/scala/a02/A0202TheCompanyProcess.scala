package com.moqi.scala.a02

import com.moqi.scala.Data.name_list

/**
 * @author moqi
 *         On 3/13/20 22:40
 */
object A0202TheCompanyProcess {

  def main(args: Array[String]): Unit = {
    val result = name_list
      .filter(_.length() > 1)
      .map(_.capitalize)
      .reduce(_ + "," + _)
    // END scala_process
    println("Process:" + result)

    // Scala 实现并行化 Process 过程
    // BEGIN scala_process_parallel
    val parallelResult = name_list
      .par
      .filter(_.length() > 1)
      .map(_.capitalize)
      .reduce(_ + "," + _)
    // END scala_process_parallel
    println("Parallel:" + parallelResult)

    println("\nBoundary:\n================")
    val boundary_result = List("")
      .filter(_.length() > 1)
      .map(_.capitalize)

    println("Boundary:" + boundary_result)
  }

}

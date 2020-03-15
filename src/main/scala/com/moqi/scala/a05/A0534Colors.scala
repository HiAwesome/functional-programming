package com.moqi.scala.a05

// Scala 中针对 case 类的匹配模式
object A0534Colors extends App {
  def printColor(c: Color): Unit = c match {
    case Red(v) => println("Red: " + v)
    case Green(v) => println("Green: " + v)
    case Blue(v) => println("Blue: " + v)
    case col: Color =>
      print("R: " + col.red + ", ")
      print("G: " + col.green + ", ")
      println("B: " + col.blue)

    case null => println("invalid color")
  }

  // END scala_colors

  printColor(new Color(34, 33, 34))
  printColor(new Color(100, 0, 0))
  printColor(Red(255))
  printColor(null)
}

// BEGIN scala_colors
class Color(val red: Int, val green: Int, val blue: Int)

case class Red(r: Int) extends Color(r, 0, 0)

case class Green(g: Int) extends Color(0, g, 0)

case class Blue(b: Int) extends Color(0, 0, b)


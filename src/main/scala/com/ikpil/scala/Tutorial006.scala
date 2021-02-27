package com.ikpil.scala

import com.ikpil.scala.sample.Rational

object Tutorial006 extends App {
  val x = new Rational(1, 2)
  println(x)

  val y = new Rational(2, 3)
  println(y)

  val z = x add y
  println(z)

  val c = x lessThan y
  println(c)

  val three = new Rational(3);
  println(three)

  val gcd = new Rational(66, 42)
  println(gcd)
}

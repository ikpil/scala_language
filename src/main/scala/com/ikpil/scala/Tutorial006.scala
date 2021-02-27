package com.ikpil.scala

import com.ikpil.scala.sample.Rational

object Tutorial006 extends App {
  val x = new Rational(1, 2)
  println(x)

  val y = new Rational(2, 3)
  println(y)

  println("연산자 정의가 작동 되는지 확인")
  val z1 = x + y
  val z2 = x * y
  println(z1)
  println(z2)

  println("연산자 우선 순위 확인")
  val z3 = (z1 + z2) * x
  val z4 = z1 + z2 * x
  println(z3)
  println(z3)

  println("클래스 메소드 호출 확인")
  val c = x lessThan y
  println(c)

  val three = new Rational(3);
  println(three)

  val gcd = new Rational(66, 42)
  println(gcd)
}

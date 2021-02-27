package com.ikpil.scala.sample

class Rational(n: Int, d: Int) {
  // 선결 조건을 추가하여, d가 0이 아님을 보장한다.
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val number: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1) // 보조 생성자

  override def toString = number + "/" + denom

  // add 호출시 상수형으로 만들기 위해서 add 의 결과를 새로운 Rational 값으로 해야 한다.
  def add(that: Rational): Rational = new Rational(
    number * that.denom + that.number * denom, denom * that.denom
  )

  def lessThan(that: Rational): Boolean =
    number * that.denom < that.number * denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

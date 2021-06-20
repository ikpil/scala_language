package com.ikpil.scala

// 흐름제어 추상화, 더블어 커링과 이름에 의한 호출 파라미터를 살펴 본다
object Tutorial009 extends App {

  higherOrderFUnction()

  def containNeg(nums: List[Int]): Boolean = {
    for (num <- nums)
      if (num < 0)
        return true

    false
  }

  def higherOrderFUnction(): Unit = {
    val a1 = containNeg(List(1, 2, 3, 4))
    println("contain neg - a1:" + a1)

    val a2 = containNeg(List(1, 2, -3, 4))
    println("contain neg - a2:" + a2)

    val a3 = List(1, 2, 3, 4).exists(_ < 0)
    println("negative exists - a3:" + a3)

    val a4 = List(1, 2, 3, 4).exists(_ % 2 == 1)
    println("odd exists - a4:" + a4)
  }
}


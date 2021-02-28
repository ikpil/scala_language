package com.ikpil.scala

import scala.io.StdIn.readLine

object Tutorial007 extends App {
  differentIf()
  checkWhile(10, 30)
  checkDoWhile()
  differentAssign()

  // 명령형 언어와 스칼라의 if 차이점
  def differentIf(): Unit = {
    val x = true
    val haha = "haha"
    val default = "default"

    // 명령형을 때, if 로 분기하여 다시 결정한다.
    {
      var y = default
      if (x) {
        y = haha
      }
      println(y)
    }

    // 스칼라에서는 if 가 값을 출력할 수 있다
    {
      val y = if (x) haha else default
      println(y)
    }

    // 그러므로 스칼라에서는 다음과 같은 코드가 가능하다
    // 이를 동일성 추론(equational reasoning)이라 하는데, 변수와 표현식이 동일하다는 뜻
    {
      println(if (x) haha else default)
    }
  }

  def checkWhile(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }

    b
  }

  def checkDoWhile(): Unit = {
    var line = ""
    do {
      line = readLine()
      println("Read: " + line)
    } while (line != "")
  }

  def differentAssign(): Unit = {
    var count = 1
    var line = ""
    // 스칼라의 할당의 결과는 Unit 이기 때문에, 비교문이 성립이 안되서 무한 루프에 빠진다.
    while ((line = readLine()) != "" && count < 2) {
      println(line)
      count += 1
    }
  }
}

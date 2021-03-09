package com.ikpil.scala

import com.ikpil.scala.sample.LongLines

// 함수와 클로저에 대해서 알아 본다
object Tutorial008 extends App {

  // checkMethod()
  firstClassFunction()

  def checkMethod() = {
    val argsV2 = Array(
      "50",
      "src/main/scala/com/ikpil/scala/Tutorial007.scala",
      "src/main/scala/com/ikpil/scala/Tutorial008.scala"
    );

    val width = argsV2(0).toInt
    for (arg <- argsV2.drop(1))
      LongLines.processFile(arg, width)
  }

  def firstClassFunction() = {
    // 함수 리터럴, 함수 값은 변수에 저장할 수 있음을 보여 준다.
    var fn = (x: Int) => x + 1
    println(fn(10))

    fn = (x: Int) => x + 9999
    println(fn(1))

    fn = (x: Int) => {
      println("We")
      println("are")
      println("here!")
      x + 1
    }

    println(fn(1))

    // 모든 컬렉션에는 foreach 가 있음
    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    someNumbers.foreach((x: Int) => println(x))

    // 모든 컬렉션에는 filter 가 있음
    val filtered = someNumbers.filter((x: Int) => x > 0)
    println(filtered)

    // 위치 표시자 문법, 파라미터에 대한 위치를 _ 로 표시 할 수 있다,
    // _ 는 위치 기반이고, 2개가 있다면, 두개의 파라미터를 받는 함수이다.
    val filtered2 = someNumbers.filter(_ > 0)
    println(filtered2)
  }
}

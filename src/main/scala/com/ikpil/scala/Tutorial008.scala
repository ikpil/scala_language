package com.ikpil.scala

import com.ikpil.scala.sample.LongLines

// 함수와 클로저에 대해서 알아 본다
object Tutorial008 extends App {

  checkMethod()

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
}

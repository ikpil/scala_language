package com.ikpil.scala

import com.ikpil.scala.sample.{ArrayElement, Element}

/** *
 * 챕터 10에서는 상속과 구성에 대해서 다룬다
 */
object Chapter010 extends App {
  classExtendTest()

  def classExtendTest(): Unit = {
    // 생성
    val ae = new ArrayElement(Array("hello", "world"))
    println("ArrayElement width:" + ae.width);

    // 서브클래스로 받는다
    val e: Element = ae
    println("Element width:" + e.width);
  }
}

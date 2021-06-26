package com.ikpil.scala.sample

// 슈퍼클래스의 생성자 호출을 보여준다.
class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width: Int = s.length

  override def height: Int = 1
}

package com.ikpil.scala.sample

class ChecksumAccumulator {
  // 접근 수식자가 없을 때, public 이다
  private var sum = 0

  def add(b: Byte): Unit = sum += b

  // 매개변수는 val 이기 때문에, 아래 코드는 컴파일 되지 않는다
  // b = 1;
  //sum += b
  //}

  def checksum(): Int = ~(sum & 0xFF) + 1

  // 리턴문이 없어도 맨 나중값을 계산하여 반환한다.
  //    ~(sum & 0xFF) + 1
  //}
}

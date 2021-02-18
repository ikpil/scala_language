package com.ikpil.scala

import com.ikpil.scala.sample.ChecksumAccumulator

object Tutorial004 {
  def main(args: Array[String]): Unit = {
    sampleClass();
  }

  // 클래스를 생성하는 방법을 다룬다
  def sampleClass(): Unit = {
    val acc = new ChecksumAccumulator()
    acc.add(3)

    // 컴파일 불가, val 이기 때문
    // acc = new ChecksumAccumulator();

    val csa = new ChecksumAccumulator()

    println(acc.checksum())
    println(csa.checksum())
  }
}

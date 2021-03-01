package com.ikpil.scala

import java.io.File
import scala.io.StdIn.readLine

object Tutorial007 extends App {
  //  differentIf()
  //  checkWhile(10, 30)
  //  checkDoWhile()
  //  differentAssign()
  // checkFor()
  grep(".*gcd.*")

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

  def fileHere(): Array[File] = {
    new File("src/main/scala/com/ikpil/scala/").listFiles
  }

  def checkFor(): Unit = {
    {
      // <- 는 재너레이터라고 부르는 문법으로 fileHere 의 원소를 하나씩 꺼내 file 에 val 형태로 할당한다.
      for (file <- fileHere())
        println(file)

      // 필터링
      // for 는 표현식으로 불리는데, if 를 이용해서 원하는 값만 필터링 할 수 있드
      for (file <- fileHere() if file.getName.endsWith(".scala"))
        println("filtered - " + file)

      // 필터링 복수를 넣을 때
      for (file <- fileHere()
           if file.isFile
           if file.getName.endsWith(".scala")
           )
        println("filtered - " + file)
    }

    // Range 타입 x to y 로 사용됨
    {
      for (i <- 1 to 4)
        println("for 1 to 4 - " + i)

      for (i <- 1 until 4)
        println("for 1 until 4 - " + i)
    }

  }

  def fileLines(file: java.io.File): List[String] = {
    scala.io.Source.fromFile(file).getLines().toList
  }

  // 중첩 iterator 을 설명한다.
  def grep(pattern: String): Unit = {
    for (
      file <- fileHere() // fileHEre 을 통해 file 을 하나씩 꺼내고
      if file.getName.endsWith(".scala"); // .scala 파일을 필터링 하고(; 이 중요하다)
      line <- fileLines(file); // 파일 내용의 라인들을 하나씩 뽑아 line 에 넣고
      trimmed = line.trim // for 중에 변수를 바인딩 한다.
      if trimmed.matches(pattern) // line 에 pattern 이 있는지 필터링 하고
    ) println(file + ": ") + line.trim // 결과를 출력
  }

  // for() 을 했을 때, 순회를 했으나, for ~ yield 를 하면 새로운 컬렉션을 만들 수 있다
  def scalaFiles =
    for {
      file <- fileHere()
      if file.getName.endsWith(".scala")
    } yield file

  // for 을 이용하여 Array[File] map Array[Int] 하였다
  val forLineLengths =
    for {
      file <- fileHere()
      if file.getName.endsWith(".scala")
      line <- fileLines(file)
      trimmed = line.trim
      if trimmed.matches(".*for.*")
    } yield trimmed.length
}

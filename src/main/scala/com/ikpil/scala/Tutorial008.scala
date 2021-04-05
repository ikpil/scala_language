package com.ikpil.scala

import com.ikpil.scala.sample.LongLines

// 함수와 클로저에 대해서 알아 본다
object Tutorial008 extends App {

  // checkMethod()
  firstClassFunction()
  checkClosure()

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

    // 부분 적용 함수(partially applied function)
    // 전체 인자 목록에 대한 위치 표시자를 뜻하며, "함수명 _" 로 사용 된다.
    // 함수명 다음에 공백이 한칸 있어야 함을 주의 해야 한다.
    someNumbers.foreach(println _)


    // 다음은 sum 함수를 만든다.
    def sum(a: Int, b: Int, c: Int) = a + b + c

    // 다음처럼 사용하면, 함수를 변수로 만들수 있다
    // a는 함수 값 객체를 나타내며 캄퍼일러가 자동으로 클래스 인스턴스로 만든다.
    val a = sum _

    // 그러므로 함수 호출() -> apply() 호출 -> sum() 호출로 이어진다.
    println(a(1, 2, 3))

    // 이 클래스에는 apply 메소드가 있다. 이 apply 메소드와 sum 이 결합된다
    println(a.apply(1, 2, 3))

    // 다음 표현 으로 생성한 s1, s2 는 같은 결과를 나타낸다.
    // 함수 아규먼트 자리에 _ 가 있으면, 전부 부분 적용 함수로 컴파일러가 이해하기 때문이다.
    val s1 = (a1: Int) => sum(1, a1, 2)
    val s2 = sum(1, _: Int, 2)

    println(s1(4))
    println(s2(4))
  }

  // 클로져는 함수 리터럴의 본문에 있는 모든 자유 변수에 대한 바인딩을 포획해서
  // 자유 변수가 없게 닫는 행위에서 따온 말이다. (프로그래밍 스칼라 책에서)
  def checkClosure() = {
    println("클로져 체크")

    var more = 1 // more 는 자유 변수이다

    // 자유 변수가 포함된 함수 리터럴을 열린 코드 조각(open term)이라 부른다. 없으면 닫힌 코드 조각
    val addMore = (x: Int) => x + more
    println(addMore(10))

    // more 가 캡쳐되어 addMore 함수 객체가 되었으므로, more 를 바꾸면 값이 변경된다.
    more = 2;
    println(addMore(10))
  }
}

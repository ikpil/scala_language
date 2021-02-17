package com.ikpil.scala.tutorial_3

import scala.collection.immutable.HashSet
import scala.collection.mutable;

object Program {
  def main(args: Array[String]): Unit = {
    immutableSet()
    mutableSet()

    immutableMap()
    mutableMap()
  }

  // 변경 불가능한 컬렉션
  def immutableSet(): Unit = {
    var jetSet = HashSet("Boeing", "Airbus")
    jetSet += "Lear"
    //jetSet.+=("Lear")
    println(jetSet)
  }

  // 변경 가능한 컬랙션
  def mutableSet(): Unit = {
    val movieSet = mutable.Set("Hitch", "Poltergeist")
    movieSet += "Shrek"
    //movieSet.+=("Shrek")
    println(movieSet)
  }

  // 변경 불가능 맵
  def immutableMap(): Unit = {
    val test = Map(
      1 -> "Go to island.",
      2 -> "Find big X on ground.",
      3 -> "Dig",
    )

    //test += (4 -> "test")

    println(test(1))
  }

  // 변경 가능한 맵
  def mutableMap(): Unit = {
    val test = mutable.Map[Int, String]();
    test += (1 -> "Go to island.")
    test += (2 -> "Find big X on ground.")
    test += (3 -> "Dig")

    println(test(2))
  }

}

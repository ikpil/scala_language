package com.ikpil.scala.tutorial_3

import scala.collection.immutable.HashSet
import scala.collection.mutable;

object Program {
  def main(args: Array[String]): Unit = {
    immutableSet()
    mutableSet()
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
}

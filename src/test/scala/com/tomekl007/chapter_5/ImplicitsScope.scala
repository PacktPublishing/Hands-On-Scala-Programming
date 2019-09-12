package com.tomekl007.chapter_5

import org.scalatest.FunSuite

class ImplicitsScope extends FunSuite {

  test("current scope") {
    implicit val n: Int = 5

    def add(x: Int)(implicit y: Int) = x + y

    add(5) // takes n from the current scope
  }

  test("explicit import"){
    import scala.collection.JavaConversions.mapAsScalaMap
    def env = System.getenv() // Java map
    val term = env("TERM")    // implicit conversion from Java Map to Scala Map
  }

  test("wildcard imports"){
    def sum[T : Integral](list: List[T]): T = {
      val integral = implicitly[Integral[T]]
      import integral._   // get the implicits in question into scope
      list.foldLeft(integral.zero)(_ + _)
    }
  }

}

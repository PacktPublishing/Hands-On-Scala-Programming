package com.tomekl007.chapter_2

import org.scalatest.FunSuite

class StandardScalaLibTest extends FunSuite {
  test("should use option type when not present") {
    // given
    val result: Option[String] = Option.empty // use it instead of null can doe None() as well
    // when
    val stringResult = result.map(v => v.toUpperCase).getOrElse("default")

    // then
    assert(stringResult == "default")
  }

  test("should use option type when present") {
    // given
    val result: Option[String] = Some("this is a value")

    // when
    val stringResult = result.map(v => v.toUpperCase).getOrElse("default")

    // then
    assert(stringResult == "THIS IS A VALUE")
  }

  test("should leverage tuple"){
    // given
    val a: (String, Int) = ("a-value", 10) // can be tuple of any number of elements
    val b: (String, Int, Int) = ("b-value", 10, 100)

    // then
    assert(a._1 == "a-value")
    assert(a._2 == 10)
    assert(b._1 == "b-value")
    assert(b._2 == 10)
    assert(b._3 == 100)
  }

  // ._1, ._2 syntax of a tuple can be hard to maintain and misleading
  // instead of using it, better use case class

  test("should use case class instead of a tuple"){
    // given
    val a = NamedTwoArgs("a-value", 10) // can be tuple of any number of elements
    val b = NamedThreeArgs("b-value", 10, 100)

    // then
    assert(a.address == "a-value")
    assert(a.salary == 10)
    assert(b.address == "b-value")
    assert(b.salary == 10)
    assert(b.rate == 100)
  }

  case class NamedTwoArgs(address: String, salary: Int)

  case class NamedThreeArgs(address: String, salary: Int, rate: Int)
}

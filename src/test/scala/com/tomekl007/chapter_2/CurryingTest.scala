package com.tomekl007.chapter_2

import org.scalatest.FunSuite

class CurryingTest extends FunSuite {

  test("should use currying") {
    // given
    val addOneTo = add(1)_

    // when
    val onePlusTen = addOneTo(10)
    val onePlusTwo = addOneTo(2)

    // then
    assert(onePlusTen == 11)
    assert(onePlusTwo == 3)
  }

  test("should invoke function with all params"){
    // given
    val res = funcWithNamedParametersDefault(1, "this")

    // then
    assert(res == "req1: 1, optional2: this")
  }


  test("should invoke function with default param"){
    // given
    val res = funcWithNamedParametersDefault(1)

    // then
    assert(res == "req1: 1, optional2: default value")
  }

  def add(a: Int)(b: Int) = a + b

  def funcWithNamedParametersDefault(req1: Int, optional2: String = "default value"): String =
    s"req1: $req1, optional2: $optional2"


}

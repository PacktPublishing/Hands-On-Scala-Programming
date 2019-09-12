package com.tomekl007.chapter_2

import org.scalatest.FunSuite

class HighOrderFunction extends FunSuite {
  test("should use function that takes function as a parameter") {
    // when
    val res = operationUsingProvider(100, v => v.toString.substring(0, 1))

    // then
    assert(res == "1")
  }

  test("should return function") {
    // given
    val f = operationReturningFunction(100)

    // when
    val res = f(1, 2)

    // then
    assert(res == 103L)
  }

  def operationUsingProvider(v1: Int, provider: Int => String): String = provider(v1)

  def operationReturningFunction(v1: Long): (Int, Int) => Long =
    (a, b) => v1 + a + b


}

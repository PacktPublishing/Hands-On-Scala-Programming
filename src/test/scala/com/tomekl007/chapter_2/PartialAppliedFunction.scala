package com.tomekl007.chapter_2

import org.scalatest.FunSuite

class PartialAppliedFunction extends FunSuite {
  test("create partial applied function") {
    // Given
    def is5InRange: (Int, Int) => Boolean = isInRange(_: Int, 5, _: Int)

    // When
    val res = is5InRange(0, 8)

    // Then
    assert(res)
  }

  test("create partial applied function and reuse multiple time") {
    // Given
    def between0and10: Int => Boolean = isInRange(0, _: Int, 10)

    assert(between0and10(5))
    //true

    assert(!between0and10(100))

  }

  def isInRange(left: Int, n: Int, right: Int): Boolean = {
    if (left < n && n < right) true else false
  }


}

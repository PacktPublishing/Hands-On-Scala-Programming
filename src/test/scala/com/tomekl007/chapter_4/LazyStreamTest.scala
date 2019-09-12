package com.tomekl007.chapter_4

import org.scalatest.FunSuite

class LazyStreamTest extends FunSuite {
  test("should create lazy stream") {
    // given
    val stream = (1 to 100000000).toStream

    // when
    val res = stream.take(3) //only evaluate when needed

    // then
    assert(res.toList == List(1, 2, 3))
  }

  def sumUp(s: Seq[Int]): Int = { s.sum }

  test("List vs Seq"){
    assert(sumUp(List(1,2,3)) == 6)
    assert(sumUp(Vector(1,2,3)) == 6)
    assert(sumUp(Seq(1,2,3)) == 6)
  }

}

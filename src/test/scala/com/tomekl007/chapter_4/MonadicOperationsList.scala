package com.tomekl007.chapter_4

import org.scalatest.FunSuite

class MonadicOperationsList extends FunSuite {
  test("should map") {
    // given
    val list = List(1, 2, 3)

    // when
    val res = list.map(element => element * 10)

    // then
    assert(res == List(10, 20, 30))
  }

  test("should flatMap") {
    // given
    val list: List[List[Int]] = List(List(1, 1, 1), List(2, 2, 2), List(3, 3, 3)) // enclosed list

    // when
    val res = list.flatMap(identity) //flat map it

    // then
    assert(res == List(1, 1, 1, 2, 2, 2, 3, 3, 3))
  }

  test("should fold") {
    // given
    val list: List[Int] = List(1, 2, 3)

    // when
    val res = list.fold(0){ // start from 0
      (accumulator, value) => accumulator + value
    }

    // then
    assert(res == 6)
  }

  test("should reduce") {
    // given
    val list: List[Int] = List(1, 2, 3)

    // when
    val res = list.reduce((x, y) => x max y) // find max

    // then
    assert(res == 3)
  }
}
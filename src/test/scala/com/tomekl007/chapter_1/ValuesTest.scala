package com.tomekl007.chapter_1

import org.scalatest.FunSuite

class ValuesTest extends FunSuite {

  test("should not allow to modify val"){
    // given
    val a = "something"

    // when
    //a = "other" compile error
  }

  test("should allow to modify var"){
    // given
    var a = "something"

    // when
    a = "other"

    // then
    assert(a.equals("other"))
  }

  test("should defer init of lazy"){
    // given
    lazy val a = { println("init"); 10}

    // when
    println("not initialized yet")

    // then
    assert(a.equals(10)) // init will happen before it
  }

  test("should use def for function"){
    // given
    def add(a: Int, b: Int) = a + b

    // then
    assert(add(1,2).equals(3))
  }

  test("should use val for function"){
    // given
    val add = (a: Int, b: Int) => a + b

    // then
    assert(add(1,2).equals(3))
  }

}

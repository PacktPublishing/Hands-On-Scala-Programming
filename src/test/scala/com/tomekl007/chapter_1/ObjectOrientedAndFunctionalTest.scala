package com.tomekl007.chapter_1

import org.scalatest.FunSuite

class ObjectOrientedAndFunctionalTest extends FunSuite {

  test("should create new instance"){
    // given new instance
    val o = ObjectOrientedAndFunctional("a-name") // it uses apply

    // when modify
    val res = o.concatenateToName("surname")

    // then
    assert(res.name.equals("a-namesurname"))
  }

}

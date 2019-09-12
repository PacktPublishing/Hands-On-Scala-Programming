package com.tomekl007.chapter_2

import org.scalatest.FunSuite

class FunctionCallByNameVsValue extends FunSuite {

  test("call by value"){
    callByValue(funWithSideEffect()) // call of side-effect fun will happen only once
  }

  test("call by name"){
    callByName(funWithSideEffect()) // it will re-compute function provided as an argument
  }

  def funWithSideEffect() = {
    println("calling something")
    1 // return value
  }

  def callByValue(x: Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }

  def callByName(x: => Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }
}

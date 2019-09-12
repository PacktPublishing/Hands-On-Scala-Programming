package com.tomekl007.chapter_3

import org.scalatest.FunSuite

class PatternMatchingTest extends FunSuite {

  test("should use simple pattern matching") {
    // given
    val x: Int = 2

    // when
    val res = x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "other"
    }

    // then
    assert(res == "two")
  }

  test("should use pattern matching with case class") {
    // given
    val a: Message = AMessage("some text")
    val b: Message = BMessage(100)

    // when
    val resA = matchMessage(a)
    val resB = matchMessage(b)

    // then
    assert(resA == "SOME TEXT")
    assert(resB == 1000)
  }

  test("should use scala conditional") {
    // when
    val res = max(1, 20)

    // then
    assert(res == 20)

  }

  private def matchMessage(msg: Message) = msg match {
    case AMessage(text) => text.toUpperCase
    case BMessage(price) => price * 10
  }


  abstract class Message

  case class AMessage(text: String) extends Message

  case class BMessage(price: Int) extends Message

  def max(a: Int, b: Int): Int = if (a > b) a else b
}

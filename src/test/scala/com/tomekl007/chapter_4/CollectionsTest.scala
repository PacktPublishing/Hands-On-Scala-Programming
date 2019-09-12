package com.tomekl007.chapter_4

import org.scalatest.FunSuite

import scala.collection.mutable.ListBuffer

class CollectionsTest extends FunSuite {
  test("should add element to immutable list") {
    // given
    val list: List[String] = List()

    // when
    val newList = list :+ "first"

    // then
    assert(list == List()) // old list was not changed because it is immutable
    assert(newList == List("first"))
  }

  test("should add element to mutable list") {
    // given
    val list = new ListBuffer[String]()

    // when
    list += "1"
    list += "2"
    list += "3"

    // then
    assert(list.toList == List("1", "2", "3"))
  }

  test("should create a immutable map") {
    // given
    val states = Map("AL" -> "Alabama", "AK" -> "Alaska")

    // when
    for ((k, v) <- states) printf("key: %s, value: %s\n", k, v) //iterate over map

    val b = states + ("NY" -> "New York")

    // then
    assert(states == Map("AL" -> "Alabama", "AK" -> "Alaska")) // states was not changed because it is immutable
    assert(b == Map("AL" -> "Alabama", "AK" -> "Alaska", "NY" -> "New York"))

  }

  test("should create a mutable map") {
    // given
    val states = scala.collection.mutable.Map[String, String]()

    // when
    states += ("AZ" -> "Arizona")
    states += ("CO" -> "Colorado", "KY" -> "Kentucky")
    assert(states.toMap == Map("AZ" -> "Arizona", "CO" -> "Colorado", "KY" -> "Kentucky"))

    states -= "KY"
    states -= ("AZ", "CO")

    // then
    assert(states.toMap == Map())


  }

}

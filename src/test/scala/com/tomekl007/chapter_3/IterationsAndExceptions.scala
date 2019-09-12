package com.tomekl007.chapter_3

import org.scalatest.FunSuite

import scala.util.{Failure, Success, Try}

class IterationsAndExceptions extends FunSuite {

  test("should iterate over collection using foreach") {
    // given
    val list = List(1, 2, 3)

    // when
    list.foreach(println(_))
  }

  test("should iterate over collection using for-comprehension") {
    // given
    val list = List(1, 2, 3)

    // when
    for (v <- list) println(v)
  }

  test("should use simple try catch block") {
    try {
      actionThatThrows()
    } catch {
      case e: Exception => e.printStackTrace()
      case _: Throwable => println("other exception")
    }
  }

  test("should use Try in Functional style") {
    val action = Try(actionThatThrows())

    action match {
      case Success(_) =>
        println("Success")
      case Failure(e) =>
        println("Failed: " + e.getMessage)
    }

  }

  def actionThatThrows(): Unit = throw new Exception("some message")
}

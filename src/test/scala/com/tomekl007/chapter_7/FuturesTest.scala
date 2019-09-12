package com.tomekl007.chapter_7

import org.scalatest.FunSuite

import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

class FuturesTest extends FunSuite {

  def blockingAction(): String = {
    Thread.sleep(1000)
    "result"
  }

  test("should handle success/failure of future"){
    val f: Future[String] = Future {
      blockingAction()
    }

    f onComplete {
      case Success(value) => println(value)
      case Failure(t) => println("An error has occurred: " + t.getMessage)
    }
  }

  test("should use monadic async callback on future"){
    // when
    val f: Future[String] = Future {
      blockingAction()
    }.map(v => v.toUpperCase())

    // then
    assert(Await.ready(f, Duration.Inf).value.get.get == "RESULT")


  }

}

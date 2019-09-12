package com.tomekl007.chapter_7

import java.util.concurrent.Executors

import org.scalatest.FunSuite

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

class FuturesTestCustomThreadPool extends FunSuite {

  def blockingAction(): String = {
    Thread.sleep(1000)
    "result"
  }

  test("should handle success/failure of future"){
    //needed by Future{}
    implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(
      Executors.newFixedThreadPool(4))

    val f: Future[String] = Future {
      blockingAction()
    }

    f onComplete {
      case Success(value) => println(value)
      case Failure(t) => println("An error has occurred: " + t.getMessage)
    }
  }

  test("should use monadic async callback on future"){
    //needed by Future{}
    implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(
      Executors.newFixedThreadPool(4))

    // when
    val f: Future[String] = Future {
      blockingAction()
    }.map(v => v.toUpperCase())

    // then
    assert(Await.ready(f, Duration.Inf).value.get.get == "RESULT")


  }

}

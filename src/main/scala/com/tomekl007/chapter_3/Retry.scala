package com.tomekl007.chapter_3

import scala.util.{Failure, Success, Try}


trait Retry {

  @annotation.tailrec
  final def retry[T](n: Int, delayMs : Int = 1000)(fn: => T): T = {
    Try {fn} match {
      case Success(x) => x
      case _ if n > 1 => {
        Thread.sleep(delayMs)
        retry(n - 1, delayMs)(fn)
      }
      case Failure(e) => throw e
    }
  }
}
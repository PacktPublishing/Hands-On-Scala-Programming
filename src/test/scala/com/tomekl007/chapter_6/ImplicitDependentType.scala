package com.tomekl007.chapter_6

import org.scalatest.FunSuite

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits._

class ImplicitDependentType extends FunSuite {

  trait IsFuture[F] {
    type T

    def apply(f: F): Future[T]
  }

  object IsFuture {
    def apply[F](implicit isf: IsFuture[F]): IsFuture[F] = isf

    implicit def mk[A] = new IsFuture[Future[A]] {
      type T = A

      def apply(f: Future[A]): Future[A] = f
    }
  }

  def logResult[Thing](thing: Thing)
                      (implicit isf: IsFuture[Thing]): Future[isf.T] =
    isf(thing) map { x =>
      println(s"I got a result of $x")
      x
    }

}

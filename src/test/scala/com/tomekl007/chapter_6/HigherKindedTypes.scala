package com.tomekl007.chapter_6

import org.scalatest.FunSuite

class HigherKindedTypes extends FunSuite {

  trait Monad[M[_]] { // [_] denote higher order types
    def op[A, B](m: M[A], f: A => M[B]): M[B]

    def zero[A](a: A): M[A]
  }

  object ListMonad extends Monad[List] {
    def op[A, B](m: List[A], f: A => List[B]) = m.flatMap(f)

    def zero[A](a: A) = List[A](a)
  }

  test("Should use higher kinded types") {
    // given
    val listMonad = ListMonad.zero(42)
    assert(listMonad == List(42))

    // when
    val result = ListMonad.op(listMonad, (i: Int) => List(i - 1, i, i + 1))

    // then
    assert(result == List(41, 42, 43))
  }

}

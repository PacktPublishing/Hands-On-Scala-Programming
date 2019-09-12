package com.tomekl007.chapter_7

import org.scalatest.FunSuite

class ParallelCollectionsTest extends FunSuite {
  test("should use parallel collections from multiple threads leveraging multiple CPUs Cores") {
    // when
    val res = List(1, 2, 3).par.filter { x => println(Thread.currentThread); x > 0 }

    // then
    assert(res == List(1, 2, 3))
  }

  test("should use normal collections for low overhead operation") {
    // when
    val start = System.currentTimeMillis()
    val res = (1 to 10000000).filter { x => x > 0 }.toList

    // then
    assert(res.nonEmpty)
    println(s"normal(low overhead) collection time: ${System.currentTimeMillis() - start}")
  }

  test("should use parallel collections for low overhead operation") {
    // when
    val start = System.currentTimeMillis()
    val res = (1 to 10000000).par.filter { x => x > 0 }.toList

    // then
    assert(res.nonEmpty)
    println(s"parallel(low overhead) collection time: ${System.currentTimeMillis() - start}")

  }

  test("should use normal collections for big overhead operation") {
    // when
    val start = System.currentTimeMillis()
    val res = (1 to 10000).filter { Thread.sleep(1000) ; x => x > 0 }.toList

    // then
    assert(res.nonEmpty)
    println(s"normal(big overhead) collection time: ${System.currentTimeMillis() - start}")
  }

  test("should use parallel collections for big overhead operation") {
    // when
    val start = System.currentTimeMillis()
    val res = (1 to 10000).par.filter { Thread.sleep(1000); x => x > 0 }.toList

    // then
    assert(res.nonEmpty)
    println(s"parallel(big overhead) collection time: ${System.currentTimeMillis() - start}")

  }

}

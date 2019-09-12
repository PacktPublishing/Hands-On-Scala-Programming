package com.tomekl007.chapter_6

import org.scalatest.FunSuite

class DependentTypes extends FunSuite{

  trait DepValue {
    type V
    val value: V
  }

  def magic(that: DepValue): that.V = that.value
  // depending on the argument, different type is returned



  test("should use dependent type") {
    def mk[T](x: T) = new DepValue {
      type V = T
      val value = x
    }

    val depInt = mk(1)
    val depString = mk("two")

    val itWorks: Int = magic(depInt)
    val again: String = magic(depString)
  }

}

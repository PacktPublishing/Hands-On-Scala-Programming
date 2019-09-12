package com.tomekl007.chapter_1

// class OP
class ObjectOrientedAndFunctional(val name: String) { // note immutability
  def concatenateToName(surname: String): ObjectOrientedAndFunctional ={
    new ObjectOrientedAndFunctional(name + surname) //note return of immutable instance - FP
  }
}

object ObjectOrientedAndFunctional {
  def apply(arg1: String): ObjectOrientedAndFunctional ={
    new ObjectOrientedAndFunctional(arg1) // companion object creation
  }
}

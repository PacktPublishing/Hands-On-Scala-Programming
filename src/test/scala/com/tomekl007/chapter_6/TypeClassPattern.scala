package com.tomekl007.chapter_6

import org.scalatest.FunSuite

class TypeClassPattern extends FunSuite {

  sealed trait Serializable
  case class Person(name: String, age: Int) extends Serializable
  case class Restaurant(name : String, brunch : Boolean) extends Serializable


  trait Serializer { def serialize: String }
  implicit def PersonToSerializer(p : Person): Serializer = new Serializer {
    def serialize: String = "Person(" + p.name + ", " + p.age + ")"
  }
  implicit def RestaurantToSerializer(r : Restaurant): Serializer = new Serializer {
    def serialize: String = "Restaurant(" + r.name + ", " + r.brunch + ")"
  }

  test("should use serializer"){
    Person("me", 42).serialize
    Restaurant("me", brunch = true).serialize


  }

}

package com.tomekl007.chapter_4

import org.scalatest.FunSuite

class CovarianceVsContravariance extends FunSuite{
  sealed abstract class Vehicle
  case class Car() extends Vehicle
  case class Motorcycle() extends Vehicle


  case class Parking[A](value: A)
  case class ParkingCovariance[+A](value: A)
  case class ParkingContravariance[-A]()

  test("invariance"){
    // val p1: Parking[Vehicle] = Parking[Car](new Car) compile error
  }

  test("covariance"){
    val p1: ParkingCovariance[Vehicle] = ParkingCovariance[Car](new Car) // Car is a Vehicle so it can be assigned because +A
  }

  test("contravariance"){
    val p1: ParkingContravariance[Car] = ParkingContravariance[Vehicle]() // Vehicle can be assigned to Car because -A

  }
}

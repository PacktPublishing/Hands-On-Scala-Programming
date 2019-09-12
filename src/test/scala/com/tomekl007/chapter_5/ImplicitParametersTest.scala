package com.tomekl007.chapter_5

import org.scalatest.FunSuite

class ImplicitParametersTest extends FunSuite {

  def withTransaction(f: Transaction => Unit): Unit = {
    val txn = new Transaction

    try {
      f(txn)
      txn.commit()
    }
    catch {
      case ex: Throwable => txn.rollback(); throw ex
    }
  }

  def op1(data: Any)(implicit transaction: Transaction) = {
    println("op1")
  }

  def op2(data: Data)(implicit transaction: Transaction) = {
    println("op2")
  }

  def op3(data: Data)(implicit transaction: Transaction) = {
    println("op3")
  }


  test("should use implicit parameter") {
    val data = Data("a")

    // without implicit parameter
    withTransaction { txn =>
      op2(data)(txn)
      op1(data)(txn)
      op3(data)(txn)
    }

    // with implicit parameter
    withTransaction { implicit txn =>
      op1(data)
      op2(data)
      op3(data)
    }
  }


  class Transaction {
    def rollback() = println("rollback")

    def commit() = println("commit")

  }

  case class Data(str: String)

}



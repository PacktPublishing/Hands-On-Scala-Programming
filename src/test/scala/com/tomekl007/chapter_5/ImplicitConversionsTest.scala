package com.tomekl007.chapter_5

import org.scalatest.FunSuite

class ImplicitConversionsTest extends FunSuite {

  import scala.language.implicitConversions

  case class TaxRate(rate: BigDecimal)
  implicit var sales_tax: TaxRate = TaxRate(0.075)
  def withTax(price: BigDecimal)(implicit tax: TaxRate) = price*(tax.rate+1)

  test("should use implicit conversion") {
    // when
    val res = withTax(15.00) // implicit TaxRate used from a scope

    // then
    assert(res == 16.1250)


  }

}

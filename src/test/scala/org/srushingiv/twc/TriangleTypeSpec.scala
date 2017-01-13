package org.srushingiv.twc

import org.scalatest._

class TriangleTypeSpec extends FlatSpec with Matchers {
  "The TriangleType object" should "correctly identify scalene triangles" in {
    TriangleType.fromSides(1, 3, 2) shouldEqual ScaleneTriangle
    TriangleType.fromSides(1.2, 3.5, 2.0) shouldEqual ScaleneTriangle
    TriangleType.fromSides("alpha", "beta", "gamma") shouldEqual ScaleneTriangle
    TriangleType.fromSides('zip, 'zap, 'zorum) shouldEqual ScaleneTriangle
    TriangleType.fromSides('a', 'b', 'c') shouldEqual ScaleneTriangle
  }

  it should "correctly identify isosceles triangles" in {
    TriangleType.fromSides(2, 3, 2) shouldEqual IsoscelesTriangle
    TriangleType.fromSides(1.2, 1.2, 2.0) shouldEqual IsoscelesTriangle
    TriangleType.fromSides("alpha", "beta", "beta") shouldEqual IsoscelesTriangle
    TriangleType.fromSides(true, true, false) shouldEqual IsoscelesTriangle
  }

  it should "correctly identify equilateral triangles" in {
    TriangleType.fromSides(true, true, true) shouldEqual EquilateralTriangle
    TriangleType.fromSides('zaphod, 'zaphod, 'zaphod) shouldEqual EquilateralTriangle
  }
}

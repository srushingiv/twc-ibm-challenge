package org.srushingiv.twc

/*
 * 1. Write a function that takes three sides of a triangle and answers if it's
 * equilateral, isosceles, or scalene.
 */

// I'm never happy returning "magic" values, so I didn't want to return String
// labels. Instead, I provide some constants that will make matching on the
// results much faster for the compiler.

sealed trait TriangleType
case object EquilateralTriangle extends TriangleType { override def toString = "equilateral" }
case object IsoscelesTriangle extends TriangleType { override def toString = "isosceles" }  
case object ScaleneTriangle extends TriangleType { override def toString = "scalene" }  

// Since the function only makes sense in the context of TriangleTypes, I put
// it in the companion object to conceptually group it with the return type and
// also to build a sort of DSL (domain specific language).

object TriangleType {
  
  // This simple function let's us mix boolean algebra and integer math.
  // It eill be used to determine how many pairs of sides are equal.
  private implicit def bool2Int(b: Boolean): Int = if (b) 1 else 0
  
  // The reason behind the "Length" type parameter is that a "Triangle" could
  // measure its sides as any type. In usage, this will most likely evaluate to
  // Double or Int, but who is to say that Chars or Strings (or anything else
  // for that matter) wouldn't ever be used? They certainly are used a lot in
  // high school geometry class! The only thing this particular function
  // signature enforces is that the sides are all measured in the same type
  // (all Ints, all Strings, etc.). We could just as easily remove the type
  // parameter entirely, and let all of the parameters be "Any", but that's
  // less type-safe than I generally like to be.
  
  /**
   * A function that takes three sides of a triangle and answers if it's
   * equilateral, isosceles, or scalene.
   */
  def fromSides[Length](a: Length, b:Length, c:Length): TriangleType = {
    ((a == b) + (b == c) + (c == a)) match {
      case 0 => ScaleneTriangle
      case 1 => IsoscelesTriangle 
      case _ => EquilateralTriangle
    }
  }

}

package org.srushingiv.twc

import org.scalatest._

class CollectionExtensionsSpec extends FlatSpec with Matchers {
  "The containsAllOf function" should "return false when any element in the second collection is missing from the first" in {
    List(1, 1, 2, 3, 5, 8).containsAllOf(Set(4, 5, 6)) shouldBe false
    Set("a", "b", "c").containsAllOf(Vector("d", "e", "f")) shouldBe false
    Vector(1.1, 1.2, 2, 3, 5, 8.3).containsAllOf(Set(4.0, 5, 6)) shouldBe false
  }

  it should "return true when all elements in the second collection appear in the first" in {
    List(1, 1, 2, 3, 5, 8).containsAllOf(Vector(8, 2, 3)) shouldBe true
    Set("a", "b", "c", "d", "e").containsAllOf(List("d", "e", "a")) shouldBe true
    Vector(1.1, 1.2, 2, 3, 5, 8.3).containsAllOf(Set(2, 5, 1.2)) shouldBe true
  }

  it should "return true when repeated elements in the second collection appear at least once in the first" in {
    List(true, false).containsAllOf(Vector(true, true, true, false, false)) shouldBe true
    Set("a", "b", "c", "d", "e").containsAllOf(List("a", "a", "a")) shouldBe true
  }
}

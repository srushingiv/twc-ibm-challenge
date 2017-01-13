package org.srushingiv.twc

import org.scalatest._

class FifthFromEndSpec extends FlatSpec with Matchers {
  "The getFifthFromEnd function" should "return None when the collection has fewer than 5 elements" in {
    Seq(1, 2, 3, 4).getFifthFromEnd shouldBe None
    List("a", "b", "c").getFifthFromEnd shouldBe None
    List('one, 'two).getFifthFromEnd shouldBe None
    Set(true).getFifthFromEnd shouldBe None
    Vector.empty.getFifthFromEnd shouldBe None
  }

  it should "correctly identify and return the fifth element from the end of a collection" in {
    Seq(1, 2, 3, 4, 5).getFifthFromEnd shouldBe Some(1)
    List("a", "b", "c", "d", "e", "f", "g").getFifthFromEnd shouldBe Some("c")
    Vector(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 11, 12.1, 13.2, 14.3).getFifthFromEnd shouldBe Some(9.9)
    List('alpha, 'beta, 'gamma, 'delta, 'epsilon, 'zeta, 'eta, 'theta, 'iota, 'kappa).getFifthFromEnd shouldBe Some('zeta)

    // TODO: Set, by nature, re-orders its elements during creation, so testing
    // with it will fail unless we get really lucky, so let's ignore for now
  }


  "The fifthFromEnd function" should "throw an IndexOutOfBoundsException when the collection has fewer than 5 elements" in {
    an [IndexOutOfBoundsException] should be thrownBy Vector(1,2,3,4).fifthFromEnd
    an [IndexOutOfBoundsException] should be thrownBy Seq("a", "b", "c").fifthFromEnd
    an [IndexOutOfBoundsException] should be thrownBy Set('one, 'two).fifthFromEnd
    an [IndexOutOfBoundsException] should be thrownBy List(true).fifthFromEnd
    an [IndexOutOfBoundsException] should be thrownBy List.empty.fifthFromEnd
  }

}

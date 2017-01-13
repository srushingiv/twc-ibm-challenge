package org.srushingiv

import scala.collection.IndexedSeqLike
import scala.collection.GenTraversableOnce

package object twc {
  
  // This is a continuation of challenge #2. Here, I am creating a DSL that
  // effectively extends any TraversableOnce-extending container with these
  // two new "fifthFromEnd" methods.
  implicit class EnrichedTraversableOnce[T](val list: TraversableOnce[T]) extends AnyVal {
    
    /**
     * Gets the value from the fifth-from-end position in the container as an
     * Option. If the container has fewer than 5 elements, will return `None`.
     */
    def getFifthFromEnd = FifthFromEnd.in(list)
    
    /**
     * Gets the value from the fifth-from-end position in the container. If the
     * container has fewer than 5 elements, will throw an
     * `IndexOutOfBoundsException`.
     */
    def fifthFromEnd = getFifthFromEnd.getOrElse {
      throw new IndexOutOfBoundsException("Input container does not contain at least 5 elements")
    }

  }
  
  
  implicit class EnrichedTraversable[T](val container: GenTraversableOnce[T]) extends AnyVal {

    /**
     * Determines if all elements of a second collection are contained in
     * this collection.
     */
    def containsAllOf(contained: GenTraversableOnce[T]) =
      CollectionExtensions.collectionContainsAllOf(container, contained)

  }

}
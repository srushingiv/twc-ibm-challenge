package org.srushingiv.twc

/*
 * 3. Given two lists, write a function that answers if all elements of one
 * list are in the other. 
 */

import scala.collection.GenTraversableOnce

object CollectionExtensions {

  /**
   * Determines if one collection contains at least one copy of each unique
   * element in a second collection.
   */
  def collectionContainsAllOf[T](container: GenTraversableOnce[T], contained:  GenTraversableOnce[T]): Boolean = {
    contained.toSet.seq -- container isEmpty
  }

}
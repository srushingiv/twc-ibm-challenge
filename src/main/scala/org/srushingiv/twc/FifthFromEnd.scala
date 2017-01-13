package org.srushingiv.twc

/*
 * For a single-linked (forward only) list write a function that returns 5th
 * element from the end of the list. The list can only be walked once (reverse,
 * length, or size of this list cannot be used).
 */

object FifthFromEnd {

  // When possible, I prefer not to limit usages of a function to a single
  // container-type, so, instead of using `List`, I'll use `TraversableOnce`.
  // List implements this trait, none of the forbidden methods are available
  // in it, and the function is usable with other container types.
  
  def in[T](list: TraversableOnce[T]): Option[T] = {
    // My first reaction to this is that the List implementation in Scala is
    // exactly this single-linked version, so my off-the-cuff response is simply:

    // list.reverse.drop(4).headOption

    // However, this uses excessive memory in cases of large lists, and would be
    // ridiculous to use on a stream of values with an indeterminate length,
    // nor is `reverse` available on TraversableOnce
    
    // probably the next simplest solution, then would be to use a fold...
    // I don't like this implementation much, as it creates tons of
    // intermediary objects in memory, but these can be garbage collected so
    // it'll do for now.
    
    (list.foldLeft[(Option[T], Option[T], Option[T], Option[T], Option[T])]((None, None, None, None, None)) {
      case ((a, b, c, d, e), value) => (Some(value), a, b, c, d)
    })._5
  }

}
package interview.trickyarray

import org.scalatest.FlatSpec
import org.slf4j.LoggerFactory

class TrickyArraySort extends FlatSpec {
  val log = LoggerFactory.getLogger(classOf[TrickyArraySort])

  def sort[T](array: TrickyArray[T]) {
    val l = array.length
    for (i <- (1 to l).reverse) {
      val index = array.getIndexOfNthLargest(i)
      array.reverseArray(index)
      array.reverseArray(i-1)
    }
    array.reverseArray(l-1)
  }

  "Tricky Array Sort" should "sort TrickyArray" in {
    val array = new TrickyArray(Array(11, 22, 26, 984, 36, 276, 37, 84, 287, 4, 9, 3, 9, 3))
    sort(array)
    assert(array.underlying.sorted.toList == array.underlying.toList, "Not sorted! Array = " + array)
  }
}



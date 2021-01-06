/*
* Module for sorting html elements based on prices and such.
*/
import scraper.extractor._
import org.jsoup._
import org.jsoup.nodes._

package scraper {

  /*
  * Object used to compare to store item elements on the mstore.
  * Compares to elements based on the prices attached to them.
  */
  class MStorePrice extends Criteria {

    /*
    * Extracts price of an element. Price is contained in a span
    * element with the itemprop "price" and the content being the
    * price value
    */
    private def extractPrice(elem: Element): Double = {
      val pelems = Extractor.extractElementChildrenByTag(elem, "span")
      var pelem: Element = null
      for(i <- 0 to pelems.size() - 1) {
        val itemprop = Extractor.
          extractElementAttribute(pelems.get(i), "itemprop")
        if(itemprop == "price") {
          pelem = pelems.get(i)
        }
      }

      Extractor.extractElementAttribute(pelem, "content").
        replace("$", "").toDouble
    }

    // Checks if the two elements have equal prices
    override def equals(left: Element, right: Element): Boolean = {
      extractPrice(left) == extractPrice(right)
    }

    // Compars the two elements based on their price
    override def compare(left: Element, right: Element): Int = {
      val pleft = extractPrice(left)
      val pright = extractPrice(right)
      if(this.equals(left, right)) {
        return 0
      }
      else if(pleft > pright) {
        return 1
      }
      else {
        return -1
      }
    }

  }

}

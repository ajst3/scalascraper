/*
* Module for sorting html elements based on prices and such.
*/
import scraper.extractor._
import org.jsoup._
import org.jsoup.nodes._

package scraper {

  class MStorePrice extends Criteria {

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

    override def equals(left: Element, right: Element): Boolean = {
      extractPrice(left) == extractPrice(right)
    }

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

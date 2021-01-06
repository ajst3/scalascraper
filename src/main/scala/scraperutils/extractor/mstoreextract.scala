/*
* Module for extracting elements and such from mstore html.
*/
import org.jsoup._
import org.jsoup.nodes._
import org.jsoup.select._
import scala.collection.mutable.ListBuffer

package scraper.extractor {

  class MStore extends Extractor {
    val gameidprefix = "productplacementlist_"

    /*
    * Gets a store element using the id of elements.
    */
    def getStoreItemElement(number: Int): Element = {
      val id = s"${gameidprefix}${number}"
      Extractor.extractElementsById(
        this.source, id)
    }

    /*
    * Gets numelements store item elements and returns them
    * as an Elements object.
    */
    def getStoreItemElements(numelements: Int): Elements = {
      var ellist = new Elements()
      var i = 0
      var next = getStoreItemElement(i)
      while(i < numelements && next != null) {
        ellist.add(next)
        i += 1
        next = getStoreItemElement(i)
      }
      ellist
    }

  }

  object MStore {

    def apply(source: String): MStore = {
      var ext = new MStore
      ext.source = source
      ext
    }

  }

}

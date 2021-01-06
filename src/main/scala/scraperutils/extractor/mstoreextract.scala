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

    def getStoreItemElement(number: Int): Element = {
      val id = s"${gameidprefix}${number}"
      Console.println(id)
      Extractor.extractElementsById(
        this.source, id)
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

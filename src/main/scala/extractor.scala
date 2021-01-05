/*
* Module for extracting elements and such from html source.
*/
import org.jsoup._
import org.jsoup.select._
import scala.collection.mutable.ListBuffer

package scraper.extractor {

  class Extractor {
    var source = ""

    def extractElementsText(tag: String): List[String] = {
      Extractor.extractElementsTextFromSource(source, tag)
    }

  }

  object Extractor {

    def apply(pagesource: String): Extractor = {
      var ext = new Extractor
      ext.source = pagesource
      ext
    }

    def extractElementsTextFromSource(source: String,
        tag: String): List[String] = {
      var strlist = new ListBuffer[String]

      val html = Jsoup.parse(source).body()
      val matched = html.getElementsByTag(tag).
        select("*")

      for(i <- 0 to matched.size() - 1) {
        strlist +=  matched.get(i).ownText()
      }
      strlist.toList
    }
  }
}

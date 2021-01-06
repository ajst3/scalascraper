/*
* Module for extracting elements and such from html source.
*/
import org.jsoup._
import org.jsoup.nodes._
import org.jsoup.select._
import scala.collection.mutable.ListBuffer

package scraper.extractor {

  class Extractor {
    var source = ""

    /*
    * Extracts elements by text for a given tag.
    */
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
      val matched = extractElementsByTag(source, tag)

      for(i <- 0 to matched.size() - 1) {
        strlist +=  matched.get(i).ownText()
      }
      strlist.toList
    }

    def extractElementsByTag(source: String, tag: String): Elements = {
      val html = Jsoup.parse(source).body()
      html.getElementsByTag(tag).select("*")
    }

    def extractElementAttribute(elem: Element, att: String): String = {
      val attributes = elem.attributes().asList()
      for(i <- 0 to attributes.size() - 1) {
        if(attributes.get(i).getKey() == att) {
          return attributes.get(i).getValue()
        }
      }
      "Element does not have that attribute"
    }

  }

}

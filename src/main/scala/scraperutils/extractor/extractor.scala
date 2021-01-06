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

    /*
    * Returns the strings attached to all of the elements that match
    * the specified tag. Returns a list of strings.
    */
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

    /*
    * Gets elements based on their tag and returns an elements object.
    */
    def extractElementsByTag(source: String, tag: String): Elements = {
      val html = Jsoup.parse(source).body()
      html.getElementsByTag(tag).select("*")
    }

    /*
    * Gets an element based on ID. Returns a singular element.
    */
    def extractElementsById(source: String, id: String): Element = {
      val html = Jsoup.parse(source).body()
      html.getElementById(id)
    }

    /*
    * For a given element, returns the value of the given attribute.
    * Returns a string saying no value was found, if there attribute
    * is not found.
    */
    def extractElementAttribute(elem: Element, att: String): String = {
      val attributes = elem.attributes().asList()
      for(i <- 0 to attributes.size() - 1) {
        if(attributes.get(i).getKey() == att) {
          return attributes.get(i).getValue()
        }
      }
      "Element does not have that attribute"
    }

    /*
    * Gets the children of a specific tag for the given element.
    * Returns an Elements object.
    */
    def extractElementChildrenByTag(elem: Element, tag: String): Elements = {
      elem.getElementsByTag(tag)
    }

  }

}

/*
* Module for extracting elements and such from html source.
*/
import scala.xml.XML
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

      val tagseq = XML.loadString(source) \\ tag
      val elementlist = tagseq.toList
      var textlist = new ListBuffer[String]()

      for(i <- 0 to elementlist.length) {
        textlist += elementlist(i).text
      }

      textlist.toList
    }

  }

}

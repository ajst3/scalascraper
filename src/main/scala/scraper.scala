/*
* Module for scraping the contents of a website.
*/
import scala.io.Source
import org.jsoup._
import org.jsoup.select._

package scraper {

  class Scraper {
    var url = ""

    def getRawSource: String = {
      Scraper.getRawSourceFromUrl(url)
    }

    /*
    * Sorts elements based on criteria defined by a criteria object
    * and returns the elements string
    */
    def sortElementsByCriteria(elems: Elements,
        cri: Criteria): List[String] = {
      List("s")  // Temporary to get compilation
    }

  }


  /*
  * Object containing methods for scraping websites.
  */
  object Scraper {

    def apply(url: String): Scraper = {
      var scrap = new Scraper
      scrap.url = url
      scrap
    }

    def getRawSourceFromUrl(url: String): String = {
      Source.fromURL(url)("ISO-8859-1").mkString
    }

  }

}

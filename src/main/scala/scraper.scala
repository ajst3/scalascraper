/*
* Module for scraping the contents of a website.
*/
import scala.io.Source

package scraper {

  class Scraper {
    var url = ""

    def getRawSource(): String = {
      Scraper.getRawSourceFromUrl(url)
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

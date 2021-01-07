/*
* Module for scraping the contents of a website.
*/
import java.util
import scala.io.Source
import scala.math._
import org.jsoup._
import org.jsoup.select._
import scala.collection.mutable.ListBuffer

package scraper {

  /*
  * Basic object used for general webscrapping operations like element
  * sorting.
  */
  class Scraper {
    var url = ""

    def getRawSource: String = Scraper.getRawSourceFromJsoup(url)

    /*
    * Sorts elements based on criteria defined by a criteria object
    * and returns the elements string
    */
    def sortElementsByCriteria(elems: Elements,
        cri: Criteria): List[String] = {
      var toreturn = elems.clone()
      mergesortElements(toreturn.subList(0, toreturn.size()), cri)

      var strlist = new ListBuffer[String]
      for(i <- 0 to toreturn.size() - 1) {
        strlist += toreturn.get(i).ownText()
      }
      strlist.toList
    }

    /*
    * Sorts elements based on criteria defined by a criteria object and
    * returns an Elements object (which is a list of the sorted elements)
    */
    def sortElementsByCriteriaMaintain(elems: Elements,
        cri: Criteria): Elements = {
      var toreturn = elems.clone()
      mergesortElements(toreturn.subList(0, toreturn.size()), cri)
      toreturn
    }

    /*
    * Uses mergesort to sort a list of elements and uses the criteria
    * object to compare the elements.
    */
    private def mergesortElements(elems: util.List[nodes.Element],
        cri: Criteria): Unit = {
      if(elems.size() <= 1) {
        return
      }

      val mid = elems.size() / 2
      var left = new util.ArrayList[nodes.Element]()
      var right = new util.ArrayList[nodes.Element]()

      for(i <- 0 to mid - 1) {
        left.add(elems.get(i))
      }
      for(i <- mid to elems.size() - 1) {
        right.add(elems.get(i))
      }

      mergesortElements(left, cri)
      mergesortElements(right, cri)

      var i = 0
      var j = 0
      var k = 0
      while(i < left.size() && j < right.size()) {
        if(cri.compare(left.get(i), right.get(j)) < 0) {
          elems.set(k, left.get(i))
          i += 1
        }
        else {
          elems.set(k, right.get(j))
          j += 1
        }
        k += 1
      }
      while(i < left.size()) {
        elems.set(k, left.get(i))
        i += 1
        k += 1
      }
      while(j < right.size()) {
        elems.set(k, right.get(j))
        j += 1
        k += 1
      }
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

    // Don't use anymore, jsoup library is more reliable for getting source
    def getRawSourceFromUrl(url: String): String = {
      Source.fromURL(url)("ISO-8859-1").mkString
    }

    // Using jsoup, gets the raw html from a given url
    def getRawSourceFromJsoup(url: String): String = {
      val doc = Jsoup.connect(url).get();
      doc.outerHtml()
    }

  }

}

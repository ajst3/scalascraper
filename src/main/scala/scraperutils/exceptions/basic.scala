/*
* Holds common basic exceptions
*/
import scala.util.control._

package scraper.exceptions {

  /*
  * Base scraper exception class
  */
  class ScraperException(msg: String) extends Exception(msg) {

    def this(msg: String, cause: Throwable) = {
      this(msg)
    }

  }

}

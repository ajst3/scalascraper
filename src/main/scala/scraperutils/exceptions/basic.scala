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

    def this() {
      this(null: String)
    }

  }

  /*
  * No Element Found Exception
  */
  class NoElementFoundException(msg: String) extends ScraperException(msg) {

    def this(msg: String, cause: Throwable) {
      this(msg)
    }

  }

  /*
  * No Attribute Exception
  */
  class NoAttributeException(msg: String) extends ScraperException(msg) {

    def this(msg: String, cause: Throwable) {
      this(msg)
    }

  }

}

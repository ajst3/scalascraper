/*
* Module for defining criteria to sort html elements.
*/
import org.jsoup._
import org.jsoup.nodes._

package scraper {

  // Base Class
  abstract class Criteria {

    // Base method which checks variable references
    def equals(left: AnyRef, right: AnyRef): Boolean = {
      left eq right
    }

    def equals(left: Element, right: Element): Boolean

    // >0 := left > right, <0 := left < right, 0 := left == right
    def compare(left: Element, right: Element): Int

  }


  class TextLength extends Criteria {

    override def equals(left: Element, right: Element): Boolean = {
      left.ownText().length() == right.ownText.length()
    }

    override def compare(left: Element, right: Element): Int = {
      if(this.equals(left, right)) {
        return 0
      }
      else if(left.ownText().length() > right.ownText().length()) {
        return 1
      }
      else {
        return -1
      }
    }

  }

}

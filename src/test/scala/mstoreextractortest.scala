import scraper._
import org.scalatest._

class TestMstore extends FunSuite {

  test("MStore Element Extraction") {
    Console.println(
        s"${Console.BLUE}${Console.WHITE_B}Creating scraper object")
    val s = Scraper(
      "https://www.microsoft.com/en-us/store/top-paid/games/xbox")
    val psource = s.getRawSource
    var ext = scraper.extractor.MStore(psource)
    val elem1 = ext.getStoreItemElement(0)
    Console.println(s"Element 1 = $elem1")
    Console.println(s"${Console.RESET}")
  }

  ignore("Mstore Price Criteria") {
    
  }

}

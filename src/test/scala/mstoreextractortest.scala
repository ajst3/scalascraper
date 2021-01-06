import scraper._
import org.scalatest._

class TestMstore extends FunSuite {

  test("MStore Element Extraction") {
    Console.println(
        s"${Console.BLUE}${Console.WHITE_B}Creating scraper object")
    val s = Scraper(
      "https://www.microsoft.com/en-us/store/top-paid/games/xbox")
    val psource = s.getRawSource
    val ext = scraper.extractor.MStore(psource)
    val elem1 = ext.getStoreItemElement(0)
    Console.println(s"Element 1 = $elem1")
    Console.println(s"${Console.RESET}")
  }

  test("Mstore Get Store Items") {
    Console.println(
        s"${Console.BLUE}${Console.WHITE_B}Getting Store Items")
    val s = Scraper(
      "https://www.microsoft.com/en-us/store/top-paid/games/xbox")
    val psource = s.getRawSource
    val ext = scraper.extractor.MStore(psource)
    val selems = ext.getStoreItemElements(5)
    Console.println(s"store items = $selems")
    Console.println(s"${Console.RESET}")
  }

  test("Mstore Sorting by Price") {
    Console.println(
        s"${Console.BLUE}${Console.WHITE_B}Sorting by Price")
    val s = Scraper(
      "https://www.microsoft.com/en-us/store/top-paid/games/xbox")
    val psource = s.getRawSource
    val ext = scraper.extractor.MStore(psource)
    val selems = ext.getStoreItemElements(5)
    val cri = new MStorePrice
    val sorted = s.sortElementsByCriteriaMaintain(selems, cri)
    for(i <- 0 to sorted.size() - 1) {
      Console.println(s"$i = ${sorted.get(i)}")
    }
    Console.println(s"${Console.RESET}")
  }

}

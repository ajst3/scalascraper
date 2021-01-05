import scraper._
import org.scalatest._

class TestScrap extends FunSuite{

  test("Extractor class Elements Text") {
    Console.println(
        s"${Console.BLUE}${Console.WHITE_B}Creating scraper object")
    val s = Scraper("https://ajst3.github.io/")
    val psource = s.getRawSource()
    var extractor = scraper.extractor.Extractor(psource)

    Console.println("Getting elements text")
    val elementstext = extractor.extractElementsText("p")
    Console.println(elementstext)
    Console.println(s"${Console.RESET}")
  }

  ignore("Sort by Criteria") {

  }
}

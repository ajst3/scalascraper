import scraper._
import org.scalatest._

class TestScrap extends FunSuite {

  test("Extractor class Elements Text") {
    Console.println(
        s"${Console.BLUE}${Console.WHITE_B}Creating scraper object")
    val s = Scraper("https://ajst3.github.io/")
    val psource = s.getRawSource
    var extractor = scraper.extractor.Extractor(psource)

    Console.println("Getting elements text")
    val elementstext = extractor.extractElementsText("p")
    Console.println(elementstext)
    Console.println(s"${Console.RESET}")
  }

  test("Extracting attributes") {
    Console.println(s"${Console.BLUE}${Console.WHITE_B} Extracting Attributes")
    val s = Scraper("https://ajst3.github.io/")
    val psource = s.getRawSource
    val aelements = extractor.Extractor.extractElementsByTag(psource, "a")
    val att1 = extractor.Extractor.
      extractElementAttribute(aelements.get(0), "href", true)
    Console.println(s"a element 1 = ${aelements.get(0)}")
    Console.println(s"href of a element 1 = ${att1}")
    Console.println(s"${Console.RESET}")
  }

  test("Sort by Basic Criteria") {
    val s = Scraper("https://ajst3.github.io/")
    val psource = s.getRawSource

    Console.println(s"${Console.BLUE}${Console.WHITE_B} Extracting p tags")
    val pelements = scraper.extractor.Extractor.
      extractElementsByTag(psource, "p")

    val cri = new TextLength()
    val sorted = s.sortElementsByCriteria(pelements, cri)

    for(i <- 0 to sorted.length - 1) {
      Console.println(s"$i = ${sorted(i)}")
    }

    val sortedm = s.sortElementsByCriteriaMaintain(pelements, cri)
    Console.println(s"sorted maintained = $sortedm")
    Console.println(s"${Console.RESET}")
  }

}

import scraper._
import org.scalatest._

class TestScrap extends FunSuite{

  test("Extractor class") {
    println("Creating scraper object")
    val s = Scraper("https://ajst3.github.io/")
    //val s = Scraper("https://www.google.com/")
    val psource = s.getRawSource()
    var extractor = scraper.extractor.Extractor(psource)

    println("Getting elements text")
    val elementstext = extractor.extractElementsText("p")
    println(elementstext)
  }
}

import scraper._
import org.scalatest._

class TestScrap extends FunSuite{
  // def basic() = {
  //   // Create Scrapper object using companion apply method
  //   val s = Scraper("https://www.google.com")
  //   println("Created scraper object")
  //
  //   // Get the raw source from the url
  //   val psource = s.getRawSource()
  //   println(psource)
  // }

  // def extractor() = {
  //   println("Creating scraper object")
  //   val s = Scraper("https://ajst3.github.io/")
  //   val psource = s.getRawSource()
  //   var extractor = scraper.extractor.Extractor(psource)
  //
  //   println("Getting elements text")
  //   val elementstext = extractor.extractElementsText("p")
  //   println(elementstext)
  // }

  test("Extractor class") {
    println("Creating scraper object")
    val s = Scraper("https://ajst3.github.io/")
    val psource = s.getRawSource()
    var extractor = scraper.extractor.Extractor(psource)

    println("Getting elements text")
    val elementstext = extractor.extractElementsText("p")
    println(elementstext)
  }
}

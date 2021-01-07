import scraper._
import org.scalatest._

@Ignore
class TestExceptions extends FunSuite {

  test("Basic exception") {
    throw new scraper.exceptions.ScraperException("This is a test msg!")
  }

  test("No Attribute Exception") {
    val s = Scraper("https://ajst3.github.io/")
    val psource = s.getRawSource
    val pelements = scraper.extractor.Extractor.
      extractElementsByTag(psource, "p")
    val elem = pelements.get(0)
    scraper.extractor.Extractor.extractElementAttribute(elem, "nonsense", true)
  }

  test("No Element FOund Exception") {
    val s = Scraper("https://ajst3.github.io/")
    val psource = s.getRawSource
    scraper.extractor.Extractor.extractElementById(psource, "nonsense")
  }

}

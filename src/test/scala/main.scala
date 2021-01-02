/*
* Main script for web scraper.
*/
import scraper._

val testing = true

object TestScrap {
  def basic() = {
    // Create Scrapper object using companion apply method
    val s = Scraper("https://www.google.com")
    println("Created scraper object")

    // Get the raw source from the url
    val psource = s.getRawSource()
    println(psource)
  }

  def extractor() = {
    println("Creating scraper object")
    val s = Scaraper("https://ajst3.github.io/")
    val psource = s.getRawSource()
    var extractor = Extractor(psource)

    println("Getting elements text")
    val elementstext = extractor.getElementsText("p")
    println(getElementsText)
  }
}

object main {

  def main(args: Array[String]): Unit = {
    if(testing && args(0) == "testbasicscrap") {
      TestScrap.basic()
    }
    if(testing && args(0) == "testextractor") {
      TestScrap.extractor()
    }
  }

}

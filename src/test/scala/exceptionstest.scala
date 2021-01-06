import scraper._
import org.scalatest._

@Ignore
class TestExceptions extends FunSuite {

  test("Basic exception") {
    throw new scraper.exceptions.ScraperException("This is a test msg!")
  }

}

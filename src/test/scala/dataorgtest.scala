import scraper._
import org.scalatest._

class TestDataStructures extends FunSuite {

  test("Store Item Test") {
    Console.println(
        s"${Console.BLUE}${Console.WHITE_B}Creating scraper object")
    val s = Scraper(
      "https://www.microsoft.com/en-us/store/top-paid/games/xbox")
    val psource = s.getRawSource
    val ext = scraper.extractor.MStore(psource)
    val elem1 = ext.getStoreItemElement(0)

    val sitem: structs.StoreItem = new structs.StoreItem("test1")
    Console.println(s"Test item id = ${sitem.getItemId}")

    sitem.addPropertyValuePair("price", "10.00")
    Console.println(
        s"test item price = ${sitem.getValue("price").asInstanceOf[String]}")
    Console.println(s"test item price as double = ${sitem.getPrice}")
    Console.println(s"test item properties = ${sitem.getProperties}")
    Console.println(s"${Console.RESET}")
  }

}

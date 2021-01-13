/*
* Module for basic data structures one might use while scraping webpages.
*/
import scala.collection.mutable.Map
import scraper.exceptions.ScraperException

package scraper.structs {

  /*
  * Abstract class that outlines the general behavior of an item.
  * That was scraped from a webpage. Item should have values that are
  * mapped to properties (strings). Each item should have an identifier
  * of some sort.
  */
  abstract class Item {
    def getProperties: List[String]

    def getValue(property: String): Any

    def getItemId: String
  }

  abstract class MutableItem extends Item {
    def setPropertyValue(property: String): Boolean
  }

  class StoreItem(id: String) extends Item {
    private var myid = id
    private var pmap: Map[String, String] = Map()

    override def getProperties: List[String] = pmap.keys.toList

    override def getItemId: String = id

    def getPrice: Double = pmap("price").toDouble

    override def getValue(property: String): Any = {
      if(!pmap.contains(property)) {
        throw new ScraperException(
            s"Store Item $id does not have property $property")
      }
      pmap(property).asInstanceOf[Any]
    }

    def addPropertyValuePair(property: String, value: String): Unit = {
      if(pmap.contains(property)) {
        val already = pmap(property)
        throw new ScraperException(
          s"Store Item $id already has property $property with value $already")
      }
      pmap(property) = value
    }

  }

}

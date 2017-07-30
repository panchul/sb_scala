import knapsack.{Building, Knapsack}
import org.scalatest._

class KnapsackSpec extends FlatSpec with Matchers {

  "Knapsack" should "solve 2 with 2" in {
    val testItemBank = Set(
      Building(2,"Two"),
      Building(4,"Four"))
    val testInventory = List()
    Knapsack.fill(2, testItemBank, testInventory) shouldEqual List(List(Building(2,"Two")))
  }

  "Knapsack" should "solve 4 with 4 and 2,2" in {
    val testItemBank = Set(
      Building(2,"Two"),
      Building(4,"Four"))
    val testInventory = List()
    Knapsack.fill(4, testItemBank, testInventory) shouldEqual List(
      List(Building(4,"Four")),
      List(Building(2,"Two"),Building(2,"Two"))
    )
  }

  "Knapsack" should "solve 1 with -3,4 and -3,2,2" in {
    val testItemBank = Set(
      Building(2,"Two"),
      Building(4,"Four")
    )
    val testInventory = List(
      Building(-3,"delete Three")
    )
    Knapsack.fill(1, testItemBank, testInventory) shouldEqual List(
      List(Building(-3,"delete Three"),Building(4,"Four")),
      List(Building(-3,"delete Three"),Building(2,"Two"),Building(2,"Two"))
    )
  }

  "Knapsack" should "solve 1 with -5,2,4 and -5,2,2,2" in {
    val testItemBank = Set(
      Building(2,"Two"),
      Building(4,"Four")
    )
    val testInventory = List(
      Building(-5,"delete Five")
    )
    Knapsack.fill(1, testItemBank, testInventory) shouldEqual List(
      List(Building(-5,"delete Five"),Building(2,"Two"),Building(4,"Four")),
      List(Building(-5,"delete Five"),Building(2,"Two"),Building(2,"Two"),Building(2,"Two"))
    )
  }

}
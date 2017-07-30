// Solving some game challenge, basically a knapsack problem
// run it as
// $ scala knapsack.scala 54

val defaultSize = 1997-1954

case class Building(
                     population:Int,
                     name:String
                   )

val defaultItemBank = Set(
  Building(14,"Hut"),
  Building(22,"Silt House"),
  Building(27,"Thatchet house"),
  Building(32,"Chalet"),
  Building(73,"Cottage"),
  Building(44,"Roof Tile House"),
  Building(111,"Clapboard House"),
  Building(67,"Frame House"),
  Building(156,"Town House"),
  Building(94,"Brimstone House"),
  Building(205,"Apartment House"),
  Building(123,"Estate House"),
  Building(207,"Country House"),
  Building(155,"Arcade House"),
  Building(259,"Gambrel Roof House"),
  Building(380,"Boarding House"),
  Building(474,"Victorian House"),
  Building(285,"Worker's House"),
  Building(510,"Tenement House")
)

val defaultInventory = List(
  Building(-259,"delete Gambrel Roof House"),

  //    Building(-474,"delete Victorian House"),
  //    Building(-474,"delete Victorian House"),
  //    Building(-474,"delete Victorian House"),
  //    Building(-474,"delete Victorian House"),
  //    Building(-474,"delete Victorian House"),
  //
  //    Building(-474,"delete Victorian House"),
  //    Building(-474,"delete Victorian House"),
  //    Building(-474,"delete Victorian House"),
  //    Building(-474,"delete Victorian House"),
  //    Building(-474,"delete Victorian House"),
  //
  //    Building(-474,"delete Victorian House"),
  //    Building(-474,"delete Victorian House"),
  Building(-474,"delete Victorian House")
)

var solMap = Map[Int,List[List[Building]]](0->Nil)

def totalPop(a: List[Building]) = a.foldLeft(0)((acc, next) => acc + next.population)

def removeAtIdx[T](idx: Int, listToRemoveFrom: List[T]): List[T] = {
  assert(listToRemoveFrom.length > idx && idx >= 0)
  val (left, _ :: right) = listToRemoveFrom.splitAt(idx)
  left ++ right
}

def fill(currSize: Int, bank: Set[Building], inventory: List[Building]) : List[List[Building]] = {
  if (solMap contains(currSize)) {
    solMap(currSize)
  } else {
    if (currSize > 0) {
      val withNoDeleting1: List[List[List[Building]]] =
        for (
          item <- bank.toList if currSize >= item.population
        ) yield {
          if (currSize == item.population) List(List(item))
          else
            fill(currSize - item.population, bank, inventory).map(n => (item :: n).sortWith((a, b) => a.population < b.population))
        }

      if (withNoDeleting1.nonEmpty) {
        val withNoDeleting = withNoDeleting1.tail.fold(withNoDeleting1.head)(_ ::: _).map(n => n.sortWith((a, b) => a.population < b.population)).distinct
          .sortWith((a, b) => {a.length < b.length})

        if(solMap.contains(currSize)) {
          solMap += (currSize -> (withNoDeleting ::: solMap(currSize)).distinct.sortWith((a, b) => {
            a.length < b.length
          }))
        } else
          solMap += (currSize -> withNoDeleting)

        withNoDeleting

      } else {

        if (inventory.nonEmpty) {
          val withDeleting1 = for (
            index2delete <- inventory.indices
          ) yield {
            fill(currSize - inventory(index2delete).population, bank, removeAtIdx(index2delete, inventory)).map(n => {
              List(inventory(index2delete)) ::: n
            })
          }

          if (withDeleting1.isEmpty) Nil
          else {
              withDeleting1.tail.fold(withDeleting1.head)(_ ::: _).map(n => n.sortWith((a, b) => a.population < b.population)).distinct.sortWith((a, b) => {
                assert(totalPop(a) == currSize)
                assert(totalPop(b) == currSize)
                a.length < b.length
              })
          }
        } else {
          Nil
        }
      }

    } else {
      Nil
    }
  }
}

val totalSize = if (args.length > 0)
  args(0) match {
    case userSize if userSize.forall(Character.isDigit) =>
      userSize.toInt
    case _ =>
      println("Integer argument expected. \nUsage:")
      println("  To start: sbt \"run [number]\"\n")
      defaultSize
  }
else
  defaultSize

println("Looking for the solution for size " + totalSize)

val solutions = fill(totalSize,defaultItemBank,defaultInventory)
val maxActions = 6

println("Total number of solutions: " + solutions.length)
println("Here are the solutions with fewer actions than " + maxActions)

solutions.filter(p=> p.length <= maxActions).reverse.foreach(
  sol => {
    println("next solution, sum " + totalPop(sol)+" total actions: " + sol.length + "----------------")
    sol.foreach(x=>println(x.name + " size " + x.population))
  })

println("Have a nice day")

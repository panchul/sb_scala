package knapsack

object KnapsackMain {
  
  val defaultSize = 1997-1954
  
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
  
  def main(args: Array[String]): Unit = {

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

    val solutions = Knapsack.fill(totalSize,defaultItemBank,defaultInventory)
    val maxActions = 6
    
    println("Total number of solutions: " + solutions.length)
    println("Here are the solutions with fewer actions than " + maxActions)

    solutions.filter(p=> p.length <= maxActions).reverse.foreach(
      sol => {
        println("next solution, sum " + Knapsack.totalPop(sol)+" total actions: " + sol.length + "----------------")
        sol.foreach(x=>println(x.name + " size " + x.population))
      })
    
    println("Have a nice day")
  }

}

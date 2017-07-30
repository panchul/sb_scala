package knapsack

object Knapsack {

  var solMap = Map[Int,List[List[Building]]](0->Nil)
  
  def totalPop(a: List[Building]) = a.foldLeft(0)((acc, next) => acc + next.population)

  def removeAtIdx[T](idx: Int, listToRemoveFrom: List[T]): List[T] = {
    assert(listToRemoveFrom.length > idx && idx >= 0)
    val (left, _ :: right) = listToRemoveFrom.splitAt(idx)
    left ++ right
    //println("removeAtIdx " + idx + " of " + listToRemoveFrom)
    //println("is " + res + ", size "+ res.length)
    //res
  }
  
  def fill(currSize: Int, bank: Set[Building], inventory: List[Building]) : List[List[Building]] = {
    //    println("fill " + currSize + " inventory: " + inventory.length)
    if (solMap contains(currSize)) {
      solMap(currSize)
    } else {
      if (currSize > 0) {
        val withNoDeleting1: List[List[List[Building]]] =
          for (
            item <- bank.toList if currSize >= item.population
          ) yield {
            //println("doing yield for " + item)
            //println("should be " + item.population + " <= " + currSize)
            if (currSize == item.population) List(List(item))
            else
              fill(currSize - item.population, bank, inventory).map(n => (item :: n).sortWith((a, b) => a.population < b.population))
          }

        if (withNoDeleting1.nonEmpty) {
          val withNoDeleting2 = withNoDeleting1.tail.fold(withNoDeleting1.head)(_ ::: _)
          val withNoDeleting3 = withNoDeleting2
            .map(n => n.sortWith((a, b) => a.population < b.population))
          val withNoDeleting4 = withNoDeleting3.distinct
          val withNoDeleting = withNoDeleting4.sortWith((a, b) => {
            assert(totalPop(a) == currSize || a.isEmpty)
            assert(totalPop(b) == currSize || b.isEmpty)
            a.length < b.length
          })
          // println("adding to Map: " + currSize) //  + " -> " + withNoDeleting)
          
          if(solMap.contains(currSize)) {
//            println("current mapping: " + solMap(currSize))
//            println("Adding mapping: " + withNoDeleting)
            solMap += (currSize -> (withNoDeleting ::: solMap(currSize)).distinct.sortWith((a, b) => {
              assert(totalPop(a) == currSize)
              assert(totalPop(b) == currSize)
              a.length < b.length
            }))
          } else
          solMap += (currSize -> withNoDeleting)

          withNoDeleting

        } else {

          if (inventory.nonEmpty) {
            //println("trying deleting")
            val withDeleting1 = for (
              index2delete <- inventory.indices
            ) yield {
              //println("Trying to delete index " + index2delete)
              fill(currSize - inventory(index2delete).population, bank, removeAtIdx(index2delete, inventory)).map(n => {
                //println("prepending " + currentInventory(index2delete))
                List(inventory(index2delete)) ::: n
              })
            }

            if (withDeleting1.isEmpty) Nil
            else {
              val withDeleting2 =
                withDeleting1.tail.fold(withDeleting1.head)(_ ::: _).map(n => n.sortWith((a, b) => a.population < b.population)).distinct.sortWith((a, b) => {
                  assert(totalPop(a) == currSize)
                  assert(totalPop(b) == currSize)
                  a.length < b.length
                })

              withDeleting2
            }
          } else {
            Nil
          }
        }

      } else {
        //println("nothing to fill")
        Nil
      }
    }
  }

}

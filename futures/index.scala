
import scala.concurrent._
import scala.util.{Success, Failure}
import ExecutionContext.Implicits.global

println("Start of the program")

val firstOccurrence: Future[Int] = Future {
  val source = scala.io.Source.fromFile("myText.txt")
  source.toSeq.indexOfSlice("myKeyword")
}

var isFound = false

firstOccurrence onComplete {
  case Success(idx) => println("The keyword first appears at position: " + idx)
			isFound = true
			println(s"isFound is now $isFound") 
  case Failure(t) => println("Could not process file: " + t.getMessage)
			isFound = true
			println(s"isFound is now $isFound") 
}

while(isFound == false) { Thread.sleep(1000) }

val firstOccurrence2: Future[Int] = Future {
  val source = scala.io.Source.fromFile("myText.txt")
  source.toSeq.indexOfSlice("myKeyword")
}

println(s"This should say 'not completed': firstOccurrence2 = $firstOccurrence2")


println("end of the program")






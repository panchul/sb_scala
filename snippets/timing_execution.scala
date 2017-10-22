// This file is a collection of simple snippets that could be run individually.
// See Scala doc page for more: https://github.com/panchul/workspace/blob/master/doc/Scala.md

// run it as
// $ scala timing_execution.sc

println("Hello there!")

def time[R](block: => R): R = {
  val time_start = System.nanoTime()
  val result = block    // call-by-name
  val time_end = System.nanoTime()
  println("Run time in ns: " + (time_end - time_start))
  result
}


time {
  println("test1")
  for(next_index <- 0 to 20) next_index 
}

time {   println("test2")
  for(next_index <- 0 to 200) next_index }

time { println("test3")
  for(next_index <- 0 to 2000) next_index }

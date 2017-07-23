
// This file is a collection of simple snippets that could be run individually.
// See Scala doc page for more: https://github.com/panchul/workspace/blob/master/doc/Scala.md

// run it as
// $ scala hello.sc

println("Hello there!")


// run it as
// $ scala hello.sc myargument0

println("Hello with the argument \"" + args(0) + "\"")


// run it as
// $ scala hello.sc my arguments are a plenty

println("With a bunch of arguments using while loop:")
var i=0
while(i < args.length) {
  println("args(" + i.toString + ") is \"" + args(i) + "\"")
  i += 1
}

println("With a bunch of arguments using foreach:")
args.foreach(println)

println("With a bunch of arguments using for:")
for(arg <- args) println(arg)

println("With a bunch of arguments using a fancy foreach:")
var counter=0
args.foreach(arg => {
  println("args(" + counter.toString + ") is \"" + arg + "\"")
  counter += 1
})

println("Using Array:")
var greetString = new Array[String](3)
greetString(0) = "number_zero"
greetString(1) = "number_one"
greetString(2) = "number_two"
println("foreach with Array:")
greetString.foreach(println)
println("for with Array:")
for(next_string <- greetString) println(next_string)
println("another for with Array, with indexing:")
for(next_index <- 0 to 2) println(greetString(next_index))

println("Using Array differently:")
var greetString2 = Array("number_zero1","number_one1","number_two1")
for(next_string <- greetString2) println(next_string)

println("Using List:")
val greetStringList = List("number_zero1","number_one1","number_two1")
for(next_string <- greetStringList) println(next_string)

println("Using cons (i.e. ::: ) to join lists (everything ending with ':' is a right operator) :")
val greetStringList2 = List("number_zero1a","number_one1b","number_two1c")
val greetStringList3 = greetStringList ::: greetStringList2
for(next_string <- greetStringList3) println(next_string)

println("Using con (i.e. :: ) to append to the head of lists :")
val greetStringList4 = "zero1a" :: "one1b" :: "two1c" :: Nil
for(next_string <- greetStringList4) println(next_string)

println("Reversing a list using .reverse :")
for(next_string <- greetStringList4.reverse) println(next_string)

println("Using List count:")
val aList = List("aaa","aaaa","bbbb", "c", "cccc")
for(next_string <- aList) println(next_string)
println("aList.count(p => p.length == 4):" + aList.count(p => p.length == 4))

println("Using List drop (removes the first elements:")
val aList2 = aList.drop(1)
for(next_string <- aList2) println(next_string)

println("Using List filter, aList.filter(s=>s.length()< 4)")
for(next_string <- aList.filter(s=>s.length()<4)) println(next_string)

println("Using List map, aList.map(s=>s+\"_something\")")
for(next_string <- aList.map(s=>s+"_something")) println(next_string)

println("Using mkString()")
println(aList.mkString(", "))

println("Using head and tail")
println("head: " + aList.head)
println("tail: " + aList.tail.mkString(","))

println("Using tuples")
val pair=(99,"Luftballons")
println(pair._1)
println(pair._2)

println("Using sets")
var jetSet=Set("Luftballons", "Boeing", "Airbus")
jetSet += "Cessna"   // <- won't work with an immutable hashset
println(jetSet.contains("Cessna"))

println("Using Maps")
var treasureMap = Map(0-> "something", 1->"something2")  // can init as treasureMap = Map[Int,String]()
treasureMap += (5->"govno") // won't work if val
println(treasureMap.mkString(", "))
println(treasureMap(1))

println("Using exceptions")
//assert(1 == 2)   // throws AssertionError


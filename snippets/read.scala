
import scala.io.Source

val myfilename = if(args.length > 0) args(0) else {
  println("INFO: using my own name as the input file")
  "read.scala"
  }

val inputLines0 = Source.fromFile(myfilename).getLines()
val maxLine = inputLines0.reduceLeft((a,b)=> { if(a.length<b.length) b else a }).length.toString.length

// Won't work without re-reading it. Probably some iterator under the hood.
val inputLines = Source.fromFile(myfilename).getLines()
for(line <- inputLines)
  println(" " * (maxLine - line.length.toString.length) + line.length + " | " + line)

  
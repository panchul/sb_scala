name := "uuid_producer_consumer"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies <++= scalaVersion(v =>
  Seq("org.scala-lang" % "scala-actors" % v)
)
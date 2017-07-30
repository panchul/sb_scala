name := "knapsack"

version := "1.0"

scalaVersion := "2.12.3"

//----------------------------------
// ScalaTest
// http://www.scalatest.org/user_guide/using_scalatest_with_sbt
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
logBuffered in Test := false
//----------------------------------

// AP: don't remember why I needed this
fork in run := true


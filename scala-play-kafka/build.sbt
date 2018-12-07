//import AssemblyKeys._
//
//assemblySettings

name := """simple-rest-scala"""

version := "1.0-SNAPSHOT"

resolvers += "krasserm at bintray" at "http://dl.bintray.com/krasserm/maven"

lazy val root = project.in(file("."))
  .enablePlugins(PlayScala)
//  .enablePlugins(JavaAppPackaging)
  .settings(
    name := "Hello",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test
  )

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka_2.10" % "0.8.2-beta",
  //"org.apache.kafka" % "kafka_2.11" % "0.10.0.1",
  //"org.apache.kafka" % "kafka_2.11" % "0.8.2.2",
  "com.101tec" % "zkclient" % "0.3"
)

//mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
//{
//  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
//  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
//  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
//  case "about.html" => MergeStrategy.rename
////  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
////  case x => old(x)
//  case x => MergeStrategy.first
//  }
//}

//assemblyMergeStrategy in assembly := {
//  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
//  case x => MergeStrategy.first
//}

//// put all libs in the lib_managed directory, that way we can distribute eclipse project files
//retrieveManaged := true


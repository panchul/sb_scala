name := """simple-rest-scala"""

version := "1.0-SNAPSHOT"

resolvers += "krasserm at bintray" at "http://dl.bintray.com/krasserm/maven"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka_2.10" % "0.8.2-beta",
  //"org.apache.kafka" % "kafka_2.11" % "0.10.0.1",
  //"org.apache.kafka" % "kafka_2.11" % "0.8.2.2",
  "com.101tec" % "zkclient" % "0.3"
)
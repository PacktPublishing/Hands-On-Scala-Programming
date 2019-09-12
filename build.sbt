name := """scala-programming"""

version := "1.0"

scalaVersion := "2.13.0"

resolvers += "Spark Packages Repo" at "https://dl.bintray.com/spark-packages/maven"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "log4j" % "log4j" % "1.2.17",
  "org.scalatest" %% "scalatest" % "2.2.6" % Test,
  "org.scalacheck" %% "scalacheck" % "1.14.0" % Test
)

javaOptions in(Test, run) ++= Seq(
  "-Dlog4j.debug=true",
  "-Dlog4j.configuration=log4j.properties")

outputStrategy := Some(StdoutOutput)

fork := true

coverageEnabled in Test := true




name := "spark-query-sql-antlr"

version := "0.0.1"

scalaVersion := "2.10.4"

logLevel := Level.Warn

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.1")

retrieveManaged := true

libraryDependencies ++= {
  Seq(
    "org.scalatest" % "scalatest_2.10" % "2.0" % "provided"
  )
}
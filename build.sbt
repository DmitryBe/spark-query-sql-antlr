
name := "spark-query-sql-antlr"

version := "0.0.1"

scalaVersion := "2.10.4"

retrieveManaged := true

antlr4GenListener in Antlr4 := true
antlr4GenVisitor in Antlr4 := true

libraryDependencies ++= {
  Seq(
    "org.scalatest" % "scalatest_2.10" % "2.0" % "provided",
    "org.antlr" % "antlr4" % "4.5"
  )
}
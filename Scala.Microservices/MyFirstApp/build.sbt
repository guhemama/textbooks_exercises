name := "MyFirstApp"

version := "0.1"

scalaVersion := "2.12.6"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += guice
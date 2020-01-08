//
// Basic project information.
//

name := "atmos"

version := "2.2"

resolvers += Resolver.sonatypeRepo("public")

description := "minimalist retry-on-failure behavior for scala"

homepage := Some(url("http://github.com/paradoxical-io/"))

startYear := Some(2013)

organization := "io.paradoxical"

organizationName := "paradoxical.io"

scalacOptions ++= Seq (
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-language:experimental.macros",
  "-unchecked",
  "-Xlint",
  "-Xfuture"
)



organizationHomepage := Some(url("http://github.com/paradoxical-io/"))

scalaVersion := "2.12.10"

crossScalaVersions := Seq("2.11.12", "2.12.10", "2.13.1")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.27" % "provided",
  "org.slf4j" % "slf4j-api" % "1.7.5" % "provided",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "org.scalamock" %% "scalamock" % "4.4.0" % "test"
)


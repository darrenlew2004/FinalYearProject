name := """course-risk-prediction-backend"""
organization := "com.courserisk"

version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.16"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test,

  // Akka and HTTP
  "com.typesafe.akka" %% "akka-http" % "10.2.10",
  "com.typesafe.akka" %% "akka-stream" % "2.6.21",
  "com.typesafe.akka" %% "akka-actor" % "2.6.21",

  // JSON handling
  "com.typesafe.play" %% "play-json" % "2.9.4",

  // Authentication
  "com.auth0" % "java-jwt" % "4.4.0",

  // Data processing
  "org.apache.commons" % "commons-math3" % "3.6.1",

  // Logging
  "ch.qos.logback" % "logback-classic" % "1.4.11"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.courserisk.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.courserisk.binders._"

dependencyOverrides += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0"
evictionErrorLevel := Level.Warn 
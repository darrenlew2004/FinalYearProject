// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.9.4")

// Web plugins
addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.1.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.6")
addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.10")
addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.4")
addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.2")
addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.4.13")

// Play enhancer - this automatically generates setters for public fields
// and rewrites accessors of these fields to use the setters. Throw this away
// if not using this feature.
addSbtPlugin("com.typesafe.sbt" % "sbt-play-enhancer" % "1.2.2")

// Play Ebean support - to enable, uncomment this line, and enable in your build.sbt using
// enablePlugins(SbtEbean). Note, this requires you to use the sbt 0.13.13+ style enabledPlugins
// syntax, and requires you to add the sbt-ebean plugin to your project's plugin dependencies.
// See https://github.com/playframework/play-ebean for more information.
// addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "6.0.0") 
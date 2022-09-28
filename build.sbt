ThisBuild / scalaVersion := "2.13.9"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """websocket""",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
    )
  )
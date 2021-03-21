import sbt._
import LibraryDependencies._

ThisBuild / scalafixDependencies += scalafixOrganizeImports

lazy val root = project
  .in(file("."))
  .settings(
    scalaVersion := "2.13.5",
    scalacOptions += "-Ymacro-annotations",
    organization := "com.nullhappens",
    name := "kafka-playground",
    fork := true,
    addCompilerPlugin(Compiler.kindProjector),
    addCompilerPlugin(Compiler.contextApplied),
    addCompilerPlugin(Compiler.betterMonadicFor),
    addCommandAlias("cpl", "compile"),
    addCommandAlias("fmt", "; scalafmtSbt; compile:scalafmt"),
    addCommandAlias("check", "; scalafmtSbtCheck; compile:scalafmtCheck"),
    addCommandAlias("lint", "; compile:scalafix --check"),
    addCommandAlias("fix", "; compile:scalafix; test:scalafix"),
    libraryDependencies ++= Seq(
      console4cats,
      log4CatsSlf4j,
      log4j2.core,
      log4j2.api,
      log4j2.slf4j,
      Cats.core,
      Cats.effect,
      Fs2.core,
      Fs2.io,
      fs2Kafka
    )
  )

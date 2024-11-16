import java.util.jar.Attributes.Name

ThisBuild / scalaVersion := Version.Scala
ThisBuild / resolvers += Resolver.mavenLocal

lazy val root = (project in file("."))
  .settings(
    name         := "$name$",
    version      := "$version$",
    organization := "$organization$",
    description  := "$description$",
    libraryDependencies ++= Seq(
      Library.vertx_lang_scala,
      Library.vertx_web,
      Library.scala_logging,
      Library.vertx_lang_scala_test % Test,
      Library.scalaTest             % Test,
      Library.logback               % Runtime,
    ),
    mainVerticle := "$package$.HttpVerticle"
  )

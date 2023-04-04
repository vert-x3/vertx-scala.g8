import java.util.jar.Attributes.Name

ThisBuild / scalaVersion := "3.2.2"
ThisBuild / resolvers    += Resolver.mavenLocal

lazy val mainVerticle = "scala:$package$.HttpVerticle"

lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++= Seq(
      Library.vertx_lang_scala,
      Library.vertx_web,
      Library.vertx_lang_scala_test % Test,
      Library.scalaTest % Test,
    ),
    Compile / mainClass := Some("io.vertx.core.Launcher"),
    Compile / packageOptions += {
      Package.ManifestAttributes(new Name("Main-Verticle") -> s"scala:\$mainVerticle")
    }
  )




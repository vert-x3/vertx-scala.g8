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
    },
    reStartArgs := Seq("run", s"scala:\$mainVerticle"),
    assemblyMergeStrategy := {
      case PathList("META-INF", "MANIFEST.MF")                  => MergeStrategy.discard
      case PathList("META-INF", xs@_*)                          => MergeStrategy.last
      case PathList("META-INF", "io.netty.versions.properties") => MergeStrategy.last
      case "module-info.class"                                  => MergeStrategy.discard
      case "org/apache/commons/jexl3/internal/MapBuilder.class" => MergeStrategy.last
      case x                                                    => assemblyMergeStrategy.value(x)
    },
    assembly / assemblyJarName := "$name;format="normalize"$.jar"
  )




import sbt.{Def, _}
import sbtassembly.AssemblyPlugin.autoImport.*
import sbtassembly.{AssemblyPlugin, PathList}
import Keys._
import spray.revolver.RevolverPlugin
import spray.revolver.RevolverPlugin.autoImport.reStartArgs
import de.gccc.jib.JibPlugin
import de.gccc.jib.JibPlugin.autoImport.*
import java.util.jar.Attributes.Name

object Build extends AutoPlugin {

  object autoImport {
    val vertxBuild = taskKey[Seq[String]]("Builds a Vert.x Scala project")
    val mainVerticle = settingKey[String]("Canonical class name of the main Verticle")
  }
  
  override def trigger = allRequirements
  
  override def requires: Plugins = AssemblyPlugin && RevolverPlugin && JibPlugin

  /**
    * Start arguments for the application. This is basically the `run` command for the
    * Vert.x Launcher and the qualified class name of the main Verticle.
    */
  private def startArgs(mainVerticleFqcn: String): List[String] = List("run", s"scala:\${mainVerticleFqcn}")
  
  import autoImport.*
  override def projectSettings: Seq[Def.Setting[_]] = 
    Vector(
      // Compilation settings
      scalacOptions ++= Vector(
        "-unchecked",
        "-deprecation",
        "-target:17",
        "-encoding", "UTF-8"
      ),
      Compile / mainClass := Some("io.vertx.core.Launcher"),
      Compile / packageOptions += {
        Package.ManifestAttributes(new Name("Main-Verticle") -> s"scala:\${mainVerticle.value}")
      },

      // SBT revolver plugin settings
      reStartArgs := startArgs(mainVerticle.value),

      // Settings for single jar assembly with the assembly plugin
      assembly / assemblyJarName := "$name;format="normalize"$.jar",
      assembly / assemblyMergeStrategy := {
        case PathList("META-INF", "MANIFEST.MF")                  => MergeStrategy.discard
        case PathList("META-INF", xs@_*)                          => MergeStrategy.last
        case PathList("META-INF", "io.netty.versions.properties") => MergeStrategy.last
        case "module-info.class"                                  => MergeStrategy.discard
        case "org/apache/commons/jexl3/internal/MapBuilder.class" => MergeStrategy.last
        case x                                                    => assemblyMergeStrategy.value(x)
      },

      // Settings for Docker image building with the jib plugin
      jibTcpPorts := List($httpPort$),
      jibBaseImage := "eclipse-temurin:17.0.6_10-jre-alpine",
      jibJvmFlags := List("-noverify", "-Djava.security.egd=file:/dev/./urandom"),
      jibUseCurrentTimestamp := true,
      jibArgs := startArgs(mainVerticle.value)
    )

}

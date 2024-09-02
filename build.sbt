// To test the template run `g8` or `g8Test` from the sbt session.
lazy val root = (project in file("."))
  .enablePlugins(ScriptedPlugin, Giter8Plugin)
  .settings(
    name := "vertx-scala.g8",
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scriptedLaunchOpts ++= List(
      "-Xms1024m",
      "-Xmx1024m",
      "-XX:ReservedCodeCacheSize=128m",
      "-XX:MaxMetaspaceSize=256m",
      "-Xss2m",
      "-Dfile.encoding=UTF-8"
    ),
    resolvers += Resolver.url("typesafe", url("https://repo.typesafe.com/typesafe/ivy-releases/"))(
      Resolver.ivyStylePatterns
    )
  )

This is a quickstart for a Vert.x Scala project. It provides two Verticles, one using the 
EventBus and one being an HTTP router. Additionally, there are test specs for those Verticles.

This project comes with `vertx-core` and `vertx-web` so you are good to go for a little REST app.
Take your time and take a look.

The application is configured to use the Vert.x Launcher for running. The Launcher needs to know the
fully-qualified class name of the **main** `ScalaVerticle`. The main `ScalaVerticle` is responsible
for setting the application up, which means it loads configuration and deploys other Verticles.


# Starting the application and testing connectivity

Start your Vert.x application in the SBT shell by issuing the following command:

```shell
reStart
```

This uses the sbt-revolver plugin to run the app (see below). You can test connectivity in a separate
shell with e.g. `curl`. Example:

```shell
curl http://localhost:$httpPort$/hello
```

You should see the HTTP response `pong`.


# Keep going with sbt-revolver

[sbt-revolver](https://github.com/spray/sbt-revolver) and Vert.x provide you with a very short
development turnaround. So, in order to continuously start your Vert.x application in a SBT shell, 
just use

```shell
~reStart
```

Your application will restart automatically as soon as one of the source files has started.


# Fat-jar

To create the runnable fat-jar use the `assembly` SBT command:
```
sbt assembly
```


# Dockerize

The project also contains everything you need to create a Docker image. It uses the 
[sbt-jib](https://github.com/sbt-jib/sbt-jib) plugin to do that. We've placed some
default configuration values in `project/Build.scala`, which you can override in the
`build.sbt` file.

To place an image in your local Docker installation, run:
```
sbt jibDockerBuild
```

To create a container and run it, use

```
docker run -p $httpPort$:$httpPort$ registry.hub.docker.com/$organization$/$name$:$version$
```

Point your browser to [http://127.0.0.1:$httpPort$/hello](http://127.0.0.1:$httpPort$/hello) and enjoy :)

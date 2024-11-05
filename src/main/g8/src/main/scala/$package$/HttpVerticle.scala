package $package$

import com.typesafe.scalalogging.LazyLogging
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.ext.web.Router
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture

import scala.concurrent.Future
import scala.language.implicitConversions

class HttpVerticle extends ScalaVerticle, LazyLogging:

  override def asyncStart: Future[Unit] =
    // Create a router to answer GET-requests to "/hello" with "world"
    val router = Router.router(vertx)
    router.get("/hello").handler(_.response.end("world"))

    vertx
      .createHttpServer()
      .requestHandler(router)
      .listen($httpPort$, "0.0.0.0")
      .mapEmpty[Unit]()
      .onSuccess(_ => logger.info("HttpVerticle started -> http://localhost:$httpPort$/hello"))

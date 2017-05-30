package $package$

import io.vertx.lang.scala.ScalaVerticle
import io.vertx.scala.ext.web.Router

import scala.concurrent.Future

class HttpVerticle extends ScalaVerticle {


  override def startFuture(): Future[_] = {
    //Create a router to answer GET-requests to "/hello" with "world"
    val router = Router.router(vertx)
    val route = router
      .get("/hello")
      .handler(_.response().end("world"))

    vertx
      .createHttpServer()
      .requestHandler(router.accept _)
      .listenFuture(8666, "0.0.0.0")
  }
}

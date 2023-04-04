package $package$

import io.vertx.lang.scala.ScalaVerticle
import scala.concurrent.Future

class BusVerticle extends ScalaVerticle:

  override def asyncStart: Future[Unit] =
    vertx
      .eventBus
      .consumer[String]("testAddress")
      .handler(_.reply("Hello World!"))
    Future.successful(())
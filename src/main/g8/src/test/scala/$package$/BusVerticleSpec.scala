package $package$

import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.lang.scala.testing.VerticleTesting

import org.scalatest.matchers.should.Matchers

import scala.language.implicitConversions


class BusVerticleSpec extends VerticleTesting[BusVerticle], Matchers:

  "BusVerticle" should "reply to a message" in {
    for {
      msg <- vertx.eventBus.request[String]("testAddress", "msg")
      assertion = msg.body should equal("Hello World!")
    } yield assertion
  }


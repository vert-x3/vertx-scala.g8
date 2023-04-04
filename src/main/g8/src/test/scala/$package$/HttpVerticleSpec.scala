package $package$

import io.vertx.core.http.HttpMethod

import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.lang.scala.testing.VerticleTesting

import org.scalatest.matchers.should.Matchers

import scala.language.implicitConversions


class HttpVerticleSpec extends VerticleTesting[HttpVerticle], Matchers:

  "HttpVerticle" should "bind to $httpPort$ and answer with 'world'" in {
    val httpClient = vertx.createHttpClient()

    for {
      req  <- httpClient.request(HttpMethod.GET, $httpPort$, "127.0.0.1", "/hello")
      res  <- req.send()
      body <- res.body.map(_.toString)
      assertion = body should equal("world")
    } yield assertion
  }


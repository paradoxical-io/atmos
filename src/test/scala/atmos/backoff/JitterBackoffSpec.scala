package atmos.backoff

import org.scalatest.{FlatSpec, Matchers}

import scala.concurrent.duration._
import scala.util.{Failure, Success}

/**
  * Test suite for [[atmos.backoff.JitterBackoff]].
  */
class JitterBackoffSpec extends FlatSpec with Matchers {

  val result = "result"
  val thrown = new RuntimeException

  "JitterBackoff" should "add jitter to the result of another backoff policy" in {
    for {
      backoff <- 1L to 100L map (100.millis * _)
      base = ExponentialBackoff(backoff)
      policy = JitterBackoff(base)
      outcome <- Seq(Success(result), Failure(thrown))
      attempt <- 1 to 10
    } policy.nextBackoff(attempt, outcome).toNanos should be <= base.nextBackoff(attempt, outcome).toNanos
  }
}

package atmos.backoff

import org.scalatest.{FlatSpec, Matchers}

import scala.concurrent.duration._
import scala.util.{Failure, Success}

/**
 * Test suite for [[atmos.backoff.CappedBackoff]].
 */
class CappedBackoffSpec extends FlatSpec with Matchers {

  val result = "result"
  val thrown = new RuntimeException

  "CappedBackoff" should "cap the result of another backoff policy" in {
    for {
      backoff <- 1L to 100L map (100.millis * _)
      cap <- Seq((0.5 * backoff.toNanos).nanos, backoff, (1.5 * backoff.toNanos).nanos)
      policy = CappedBackoff(ConstantBackoff(backoff), cap)
      outcome <- Seq(Success(result), Failure(thrown))
      attempt <- 1 to 10
    } policy.nextBackoff(attempt, outcome).toNanos should be <= cap.toNanos
  }
}

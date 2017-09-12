package atmos.backoff

import atmos.BackoffPolicy

import scala.concurrent.duration._
import scala.util.{Random, Try}

/**
  * A policy that randomly spreads backoff attempts over the range provided by another policy
  *
  * @param policy The base policy to which jitter should be applied
  */
case class JitterBackoff(policy: BackoffPolicy) extends BackoffPolicy {
  override def nextBackoff(attempts: Int, outcome: Try[Any]) = {
    (policy.nextBackoff(attempts, outcome).toNanos * Random.nextDouble()).toLong.nanos
  }
}

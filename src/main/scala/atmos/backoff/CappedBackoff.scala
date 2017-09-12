package atmos.backoff

import atmos.BackoffPolicy

import scala.concurrent.duration.FiniteDuration
import scala.util.Try


/**
  * A policy that uses the minimum of either the cap or the result of the base policy.
  *
  * @param policy The base policy to be capped
  * @param cap    The maximum backoff
  */
case class CappedBackoff(policy: BackoffPolicy, cap: FiniteDuration) extends BackoffPolicy {
  override def nextBackoff(attempts: Int, outcome: Try[Any]) = {
    val next = policy.nextBackoff(attempts, outcome)
    if (next > cap) cap else next
  }
}

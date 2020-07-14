package movie

import Money
import Screening
import discountcondition.DiscountCondition
import java.time.Duration

abstract class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: MutableList<DiscountCondition>? = null
) {

    fun calculateMovieFee(screening: Screening): Money {
        return if (isDiscountable(screening)) {
            fee.minus(calculateDiscountAmount())
        } else fee
    }

    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions!!.any { condition ->
            condition.isSatisfiedBy(screening)
        }
    }

    abstract fun calculateDiscountAmount(): Money
}
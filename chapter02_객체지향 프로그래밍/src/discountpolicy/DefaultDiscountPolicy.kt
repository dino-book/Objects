package discountpolicy

import Money
import Screening
import discountcondition.DiscountCondition

abstract class DefaultDiscountPolicy(vararg conditions: DiscountCondition) : DiscountPolicy {
    private val conditions: List<DiscountCondition> = conditions.toList()

    override fun calculateDiscountAmount(screening: Screening): Money {
        conditions.forEach { each ->
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }

        return Money.ZERO
    }

    internal abstract fun getDiscountAmount(screening: Screening): Money
}
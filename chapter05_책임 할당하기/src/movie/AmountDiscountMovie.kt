package movie

import Money
import discountcondition.DiscountCondition
import java.time.Duration

class AmountDiscountMovie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountAmount: Money,
    private val discountConditions: MutableList<DiscountCondition>
) : Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money {
        return discountAmount
    }
}
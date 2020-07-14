package discountcondition

import Screening

class SequenceCondition(
    private val sequence: Int
) : DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean {
        return sequence == screening.sequence
    }
}
package discountcondition

import Screening

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}

package discountpolicy

import Money
import Screening

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}
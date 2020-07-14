package movie

import Money
import java.time.Duration

class NoneDiscountMovie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money
) : Movie(title, runningTime, fee) {

    override fun calculateDiscountAmount(): Money {
        return Money.ZERO
    }
}
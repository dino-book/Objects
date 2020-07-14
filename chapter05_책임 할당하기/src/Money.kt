import java.math.BigDecimal

class Money(private val amount: BigDecimal) {
    companion object {
        val ZERO = Money.wons(0)

        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun wons(amount: Double): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }

    fun plus(amount: Money): Money {
        return Money(this.amount.add(amount.amount))
    }

    fun minus(amount: Money): Money {
        return Money(this.amount.subtract(amount.amount))
    }

    fun times(percent: Double): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(percent)))
    }

    fun times(percent: Int): Money {
        return Money(this.amount.multiply(BigDecimal.valueOf(percent.toLong())))
    }

    fun isLessThen(other: Money): Boolean {
        return amount < other.amount
    }

    fun isGreaterThenOrEqual(other: Money): Boolean {
        return amount >= other.amount
    }

}
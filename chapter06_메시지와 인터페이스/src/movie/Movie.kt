package movie

import Money
import discountcondition.DiscountCondition
import discountcondition.DiscountConditionType
import java.lang.IllegalArgumentException
import java.time.Duration
import java.time.LocalDateTime

class Movie {
    private val title: String
    private val runningTime: Duration
    private val fee: Money
    private val discountConditions: MutableList<DiscountCondition>

    private val movieType: MovieType
    private val discountAmount: Money
    private val discountPercent: Double

    fun calculateAmountDiscountedFee(): Money {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return fee.minus(fee.times(discountPercent))
    }

    fun calculateNoneDiscountedFee(): Money {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return fee
    }

    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        for (condition in discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.dayOfWeek, whenScreened.toLocalTime())) {
                    return true
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true
                }
            }
        }

        return false
    }

    // getter와 setter
    fun getMovieType(): MovieType {
        return movieType
    }

    fun getFee(): Money {
        return fee
    }

    fun getDiscountConditions(): MutableList<DiscountCondition> {
        return discountConditions
    }

    fun getDiscountAmount(): Money {
        return discountAmount
    }

    fun getDiscountPercent(): Double {
        return discountPercent
    }
}
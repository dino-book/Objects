package discountcondition

import java.lang.IllegalArgumentException
import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition {
    private val type: DiscountConditionType

    private val sequence: Int

    private val dayOfWeek: DayOfWeek
    private val startTime: LocalTime
    private val endTime: LocalTime

    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (type != DiscountConditionType.PERIOD) {
            throw IllegalArgumentException()
        }

        return this.dayOfWeek == dayOfWeek &&
                this.startTime <= time &&
                this.endTime >= time
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (type != DiscountConditionType.PERIOD) {
            throw IllegalArgumentException()
        }

        return this.sequence == sequence
    }

    fun getType(): DiscountConditionType {
        return type
    }

    fun getSequence(): Int {
        return sequence
    }

    fun getDayOfWeek(): DayOfWeek {
        return dayOfWeek
    }

    fun getStartTime(): LocalTime {
        return startTime
    }

    fun getEndTime(): LocalTime {
        return endTime
    }
}
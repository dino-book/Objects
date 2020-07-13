import discountcondition.DiscountConditionType
import movie.MovieType

class ReservationAgency {
    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val fee = screening.calculateFee(audienceCount)
        return Reservation(customer, screening, fee, audienceCount)
        
//        val movie = screening.getMovie()
//
//        var discountable = false
//        for (condition in movie.getDiscountConditions()) {
//            if (condition.getType() == DiscountConditionType.PERIOD) {
//                discountable = screening.getWhenScreened().dayOfWeek == condition.getDayOfWeek() &&
//                        condition.getStartTime() <= screening.getWhenScreened().toLocalTime() &&
//                        condition.getEndTime() >= screening.getWhenScreened().toLocalTime()
//            } else {
//                discountable = condition.getSequence() == screening.getSequence()
//            }
//
//            if (discountable) {
//                break
//            }
//        }
//
//        var fee: Money = Money.ZERO
//        if (discountable) {
//            var discountAmount = Money.ZERO
//
//            when (movie.getMovieType()) {
//                MovieType.AMOUNT_DISCOUNT -> {
//                    discountAmount = movie.getDiscountAmount()
//                }
//                MovieType.PERCENT_DISCOUNT -> {
//                    discountAmount = movie.getFee().times(movie.getDiscountPercent())
//                }
//                MovieType.NONE_DISCOUNT -> {
//                    discountAmount = Money.ZERO
//                }
//            }
//
//            fee = movie.getFee().minus(discountAmount)
//        } else {
//            fee = movie.getFee()
//        }
//
//        return Reservation(customer,screening, fee, audienceCount)
    }
}
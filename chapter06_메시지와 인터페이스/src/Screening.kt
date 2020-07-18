import movie.Movie
import movie.MovieType
import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {

    fun calculateFee(audienceCount: Int): Money {
        when (movie.getMovieType()) {
            MovieType.AMOUNT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount)
                }
            }
            MovieType.PERCENT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(audienceCount)
                }
            }
            MovieType.NONE_DISCOUNT -> {
                return movie.calculateNoneDiscountedFee().times(audienceCount)
            }
        }

        return movie.calculateNoneDiscountedFee().times(audienceCount)
    }

    fun getMovie(): Movie {
        return movie
    }

    fun getSequence(): Int {
        return sequence
    }

    fun getWhenScreened(): LocalDateTime {
        return whenScreened
    }
}
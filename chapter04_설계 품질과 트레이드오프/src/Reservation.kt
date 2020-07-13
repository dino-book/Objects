class Reservation(
    private val customer: Customer,
    private val screening: Screening,
    private val fee: Money,
    private val audienceCount: Int
) {
    fun getCustomer(): Customer {
        return customer
    }

    fun getScreening(): Screening {
        return screening
    }

    fun getFee(): Money {
        return fee
    }

    fun getAudienceCount(): Int {
        return audienceCount
    }
}
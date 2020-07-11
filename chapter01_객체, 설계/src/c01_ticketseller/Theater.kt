package c01_ticketseller

class Theater(val ticketSeller: TicketSeller) {

    fun enter(audience: Audience) {
        ticketSeller.sellTo(audience)
    }
}
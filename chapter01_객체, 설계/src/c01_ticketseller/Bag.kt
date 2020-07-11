package c01_ticketseller

class Bag(val invitation: Invitation?, var amount: Long) {
    var ticket: Ticket? = null

    constructor(amount: Long) : this(null, amount)

    private fun hasInvitation(): Boolean {
        return invitation != null
    }

    private fun hasTicket(): Boolean {
        return ticket != null
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }

    fun hold(ticket: Ticket): Long {
        this.ticket = ticket
        return if (hasInvitation()) {
            0L
        } else {
            minusAmount(ticket.fee!!)
            ticket.fee!!
        }
    }
}
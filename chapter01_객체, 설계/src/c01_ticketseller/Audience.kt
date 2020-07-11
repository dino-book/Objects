package c01_ticketseller

class Audience(val bag: Bag) {

    fun buy(ticket: Ticket): Long {
        return bag.hold(ticket)
    }
}
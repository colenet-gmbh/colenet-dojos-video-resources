data class Flight(val id: String, val start: Int, val duration: Int, val price: Int)

fun calculatePrice(combination: List<Flight>): Int {
    return combination.sumOf { it.price }
}

fun  findFollowUpFlights(startFlight: Flight, possibleFlights: List<Flight>): List<Flight> {
    val earliestPossibleStartTime: Int = startFlight.start + startFlight.duration
    return possibleFlights.filter { it.start >= earliestPossibleStartTime }
}
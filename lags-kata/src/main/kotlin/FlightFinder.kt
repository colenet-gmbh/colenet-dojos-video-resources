data class Flight(val id: String, val start: Int, val duration: Int, val price: Int)

fun calculatePrice(combination: List<Flight>): Int {
    return combination.sumOf { it.price }
}

fun findFollowUpFlights(startFlight: Flight, possibleFlights: List<Flight>): List<Flight> {
    val earliestPossibleStartTime: Int = startFlight.start + startFlight.duration
    return possibleFlights.filter { it.start >= earliestPossibleStartTime }
}

fun findCombinations(possibleFlights: List<Flight>): List<List<Flight>> {
    val flightCombinations = possibleFlights.map { flight -> listOf(flight) }.toMutableList()

    possibleFlights
        .map { flight -> listOf(flight) + findFollowUpFlights(flight, possibleFlights) }
        .filter { it.size > 1 }
        .forEach { flightCombinations.add(it) }

    return flightCombinations
}

fun bestCombination(combinations: List<List<Flight>>): Pair<List<Flight>, Int> =
    combinations
        .map { Pair(it, calculatePrice(it)) }
        .maxByOrNull { (_, price) -> price }
        ?: Pair(listOf(), 0)


fun findBestCombination(flights: List<Flight>): Pair<List<Flight>, Int> = bestCombination(findCombinations(flights))


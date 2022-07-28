data class Flight(val id: String, val start: Int, val duration: Int, val price: Int)

fun calculatePrice(combination: List<Flight>): Int {
    return combination.sumOf { it.price }
}

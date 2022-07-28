import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class MainKtTest {

    /* Possible request input
        AF514 0 5 10
        CO5 3 7 14
        AF515 5 9 7
        BA01 6 9 8
    */

    @Test
    internal fun should_return_total_price_of_given_combination() {
        val combination = listOf(
            Flight("AF514", 0, 5, 10), Flight("BA01", 6, 9, 8)
        )
        assertThat(calculatePrice(combination)).isEqualTo(18);
    }

    @Test
    internal fun should_return_zero_for_empty_list() {
        val combination = listOf<Flight>()
        assertThat(calculatePrice(combination)).isZero()
    }

    @Test
    internal fun should_return_price_of_single_entry_for_one_element_list() {
        val combination = listOf(Flight("B", 6, 9, 643))
        assertThat(calculatePrice(combination)).isEqualTo(643)
    }

    @Test
    internal fun findFollowUpFlights_should_return_list_of_follow_up_flights() {
        val startFlight = Flight("B", 0, 6, 643)
        val possibleFlights = listOf(
            Flight("AF514", 0, 5, 10), Flight("BA01", 6, 9, 8)
        )
        val followUpFlights = findFollowUpFlights(startFlight, possibleFlights)

        val expected = listOf(Flight("BA01", 6, 9, 8))
        assertThat(followUpFlights).containsExactlyElementsOf(expected);
    }

    @Test
    internal fun findFollowUpFlights_should_return_list_of_two_follow_up_flights() {
        val startFlight = Flight("B", 0, 6, 643)
        val possibleFlights = listOf(
            Flight("AF514", 0, 5, 10),
            Flight("BA01", 6, 9, 8),
            Flight("BA05", 15, 1, 1),
        )
        val followUpFlights = findFollowUpFlights(startFlight, possibleFlights)

        val expected = listOf(
            Flight("BA01", 6, 9, 8), Flight("BA05", 15, 1, 1)
        )
        assertThat(followUpFlights).containsExactlyElementsOf(expected);
        assertThat(followUpFlights).doesNotContain(Flight("AF514", 0, 5, 10));
    }

    @Test
    internal fun `find valid combinations of flights`() {
        val flightA = Flight("A", 0, 1, 10)
        val flightB = Flight("B", 2, 1, 10)

        val possibleFlights = listOf(
            flightA,
            flightB,
        )

        val result: List<List<Flight>> = findCombinations(possibleFlights)
        val expected = listOf(
            listOf(flightA),
            listOf(flightB),
            listOf(flightA, flightB),
        )
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected)
    }

    @Test
    internal fun `find valid combinations of flights 2`() {
        val flightA = Flight("A", 0, 1, 10)
        val flightB = Flight("B", 0, 1, 10)

        val possibleFlights = listOf(
            flightA,
            flightB,
        )

        val result: List<List<Flight>> = findCombinations(possibleFlights)
        val expected = listOf(
            listOf(flightA),
            listOf(flightB),
        )
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected)
    }

    @Test
    internal fun `find valid combinations of flights 3`() {
        val flightA = Flight("A", 0, 1, 1)
        val flightB = Flight("B", 0, 1, 2)
        val flightC = Flight("C", 1, 1, 3)

        val possibleFlights = listOf(
            flightA,
            flightB,
            flightC
        )

        val result: List<List<Flight>> = findCombinations(possibleFlights)
        val expected = listOf(
            listOf(flightA),
            listOf(flightB),
            listOf(flightC),
            listOf(flightA, flightC),
            listOf(flightB, flightC)
        )
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected)
    }

    @Test
    internal fun `find most expensive combination`() {
        val flightA = Flight("A", 0, 1, 1)
        val flightB = Flight("B", 0, 1, 2)
        val flightC = Flight("C", 1, 1, 3)

        val combinations = listOf(
            listOf(flightA),
            listOf(flightB),
            listOf(flightC),
            listOf(flightA, flightC),
            listOf(flightB, flightC)
        )

        val result: Pair<List<Flight>, Int> = bestCombination(combinations)
        val expected = Pair(listOf(flightB, flightC), 5)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    internal fun `acceptance test`() {
        val flightAF514 = Flight("AF514", 0, 5, 10)
        val flightCO5 = Flight("CO5", 3, 7, 14)
        val flightAF515 = Flight("AF515", 5, 9, 7)
        val flightBA01 = Flight("BA01", 6, 9, 8)

        val flights = listOf(
            flightAF514,
            flightCO5,
            flightAF515,
            flightBA01,
        )
        val result:Pair<List<Flight>, Int> = findBestCombination(flights)
        val expected =Pair(listOf(flightAF514, flightBA01), 18)
        assertThat(result).isEqualTo(expected)
    }

}

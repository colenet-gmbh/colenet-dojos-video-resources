import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

data class Flight( val id: String, val start: Int, val duration: Int, val price: Int )

private fun calculatePrice(combination: List<Flight>): Int {
    return combination.sumOf { it.price }
}

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
            Flight("AF514", 0,5,10),
            Flight("BA01", 6,9,8)
        )
        assertThat(calculatePrice(combination)).isEqualTo(18);
    }

}

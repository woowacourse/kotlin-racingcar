package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarsTest {
    private lateinit var cars: Cars
    private val generator = object : NumberGenerator {
        private val numbers = mutableListOf(2, 5, 3, 9, 6, 4, 1, 3, 7, 8)

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
    private val names = listOf("pobi", "woni", "jun", "ver", "glo")

    @BeforeEach
    fun setUp() {
        cars = Cars(generator, names)
    }

    @Test
    fun `1회 경주`() {
        val expected = listOf(0, 1, 0, 1, 1)
        val results = cars.raceOneTime()
        results.mapIndexed { index, result ->
            assertThat(result.getDistance()).isEqualTo(expected[index])
        }
    }

    @Test
    fun `우승자 찾기`() {
        for (t in 0 until 2) {
            cars.raceOneTime()
        }
        assertThat(cars.findWinners().getWinners()).containsExactly("ver", "glo")
    }
}

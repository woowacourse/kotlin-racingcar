package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 이동 테스트`() {
        val generator = TestNumberGenerator(listOf(2, 4, 3, 9, 5, 0))
        val name = "pobi"
        val car = Car(generator, name)
        val raceTraces = listOf("", "-", "-", "--", "---", "---")
        raceTraces.map { trace -> assertThat(car.race().getResult()).isEqualTo("$name : $trace") }
    }

    class TestNumberGenerator(numbers: List<Int>) : NumberGenerator {
        private val numbers = numbers.toMutableList()

        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}

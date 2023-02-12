package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 이동 테스트`() {
        val generator = object : NumberGenerator {
            private val numbers = mutableListOf(2, 4, 3, 9, 5, 0)

            override fun generate(): Int {
                return numbers.removeAt(0)
            }
        }
        val name = "pobi"
        val car = Car(generator, name)
        val distances = listOf(0, 1, 1, 2, 3, 3)
        distances.map { distance -> assertThat(car.race().getDistance()).isEqualTo(distance) }
    }
}

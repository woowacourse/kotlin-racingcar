package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `값이 4인 경우 이동한다`() {
        val car = Car("Tom", 0)
        car.tryMove(TestNumberGenerator(4))
        assertThat(car.getMoveCount() == 1)
    }

    @Test
    fun `값이 3인 경우 이동하지 않는다`() {
        val car = Car("Tom", 0)
        car.tryMove(TestNumberGenerator(3))
        assertThat(car.getMoveCount() == 0)
    }

    class TestNumberGenerator(private val number: Int) : CarNumberGenerator {
        override fun generate(): Int {
            return number
        }
    }
}

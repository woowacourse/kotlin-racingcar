package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `값이 4인 경우 이동한다`() {
        val car = Car("Tom", INITIAL_MOVE_COUNT)
        car.tryMove(TestNumberGenerator(MIN_MOVE_NUMBER).generate())
        assertThat(car.moveCount).isEqualTo(EXPECTED_MOVE_COUNT)
    }

    @Test
    fun `값이 3인 경우 이동하지 않는다`() {
        val car = Car("Tom", INITIAL_MOVE_COUNT)
        car.tryMove(TestNumberGenerator(NOT_MOVE_NUMBER).generate())
        assertThat(car.moveCount).isEqualTo(INITIAL_MOVE_COUNT)
    }

    class TestNumberGenerator(private val number: Int) : CarNumberGenerator {
        override fun generate(): Int {
            return number
        }
    }

    companion object {
        private const val INITIAL_MOVE_COUNT = 0
        private const val EXPECTED_MOVE_COUNT = 1
        private const val MIN_MOVE_NUMBER = 4
        private const val NOT_MOVE_NUMBER = 3
    }
}

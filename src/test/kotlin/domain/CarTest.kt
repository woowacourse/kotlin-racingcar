package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    companion object {
        const val INITIAL_POSITION = 4
    }

    @Test
    internal fun `Car moves forward if the given number is over or equal to 4`() {
        val car = Car(TestMoveStrategy(4), Position(INITIAL_POSITION))
        car.move()
        assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION + 1)
    }

    @Test
    internal fun `Car stays if the given number is under 4`() {
        val car = Car(TestMoveStrategy(3), Position(INITIAL_POSITION))
        car.move()
        assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION)
    }
}

package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CarTest {
    companion object {
        const val INITIAL_POSITION = 2

        @JvmStatic
        fun arguments() = listOf(
            Arguments.of("moves forward if the given number is over or equal to 4", 4, Position(INITIAL_POSITION + 1)),
            Arguments.of("stays if the given number is under 4", 3, Position(INITIAL_POSITION))
        )
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("arguments")
    internal fun move(message: String, value: Int, expected: Position) {
        val car = Car(TestEngine(value), Position(INITIAL_POSITION))
        car.move()
        assertThat(car.position).isEqualTo(expected)
    }
}

package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CarTest {
    @Test
    @DisplayName("자동차 생성")
    internal fun constructor() {
        assertThat(Car(Position()) { true }).isNotNull
    }

    @ParameterizedTest
    @DisplayName("자동차 이동")
    @MethodSource("createStrategyAndPosition")
    fun move(condition: Boolean, value: Int) {
        val car = Car(Position()) { condition }
        val startPosition = car.position()
        car.move()

        assertThat(car.position()).isEqualTo(startPosition + value)
    }

    companion object {
        @JvmStatic
        fun createStrategyAndPosition() = listOf(
                Arguments.of(true, 1),
                Arguments.of(false, 0)
        )
    }
}
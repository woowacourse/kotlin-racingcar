package car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CarTest {
    companion object {
        @JvmStatic
        fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, false),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(9, true)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("generateData")
    fun `랜덤값에 따라 이동여부가 결정된다`(randomValue: Int, expected: Boolean) {
        val car: Car = Car(4)
        assertThat(car.isMovable(randomValue)).isEqualTo(expected)
    }

    @Test
    fun `이동 한 만큼 자동차의 위치가 변한다`() {
        val car = Car(4)
        car.move(1)
        car.move(5)
        car.move(9)
        assertThat(car.position).isEqualTo(Position(2))
    }
}
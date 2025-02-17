package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.generator.trymove.TryMoveNumbersExtractor
import racingcar.domain.model.Car

class CarTest {
    @ParameterizedTest
    @MethodSource("getMoveNumbers")
    fun `자동차가 이동을 시도하는 숫자가 4이상일 경우에 위치를 상승시키는 테스트`(
        tryNumbers: List<Int>,
        actual: Int,
    ) {
        val car = Car("동전", tryMoveNumberStrategy = TryMoveNumbersExtractor(tryNumbers))
        repeat(tryNumbers.size) { car.move() }
        assertThat(actual).isEqualTo(car.position)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef", "익명1234", "123456"])
    fun `자동차 이름이 5자 초과일 경우 예외 발생 테스트`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    companion object {
        @JvmStatic
        fun getMoveNumbers(): List<Arguments> {
            return listOf(
                Arguments.arguments(listOf(1, 2, 3, 4, 5, 6), 3),
                Arguments.arguments(listOf(0, 2, 8, 9, 1), 2),
                Arguments.arguments(listOf(0, 19, 22, 33, 82, 1), 4),
            )
        }
    }
}

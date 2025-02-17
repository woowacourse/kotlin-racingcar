package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.strategy.FakeMoveStrategy

class CarTest {
    @Test
    @DisplayName("자동차 객체 이동 전략 테스트")
    fun carMoveStrategyTest() {
        val car = Car("name")
        val moves = listOf(true, true, false, false)
        val strategy = FakeMoveStrategy(moves)
        repeat(moves.size) {
            car.moveByStrategy(strategy)
        }
        assertThat(car.distance).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "여섯자차이름"])
    @DisplayName("올바르지 않은 자동자 이름 테스트")
    fun carNameExceptionTest(strings: String) {
        assertThrows<IllegalArgumentException> {
            Car(strings)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["일", "12", "123", "four", "1이345", "일 삼 오"])
    @DisplayName("올바른 자동자 이름 테스트")
    fun carNameTest(strings: String) {
        assertNotNull {
            Car(strings)
        }
    }
}

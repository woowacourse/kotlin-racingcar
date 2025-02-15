package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car

class CarModelTest {
    private lateinit var inputValidator: InputValidator
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        inputValidator = InputValidator()
        car = Car("테스트", inputValidator)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @DisplayName("랜덤 값에 의한 전진 테스트")
    fun forwardCarByValue(moveValue: Int) {
        car.moveByValue(moveValue)
        assertThat(car.distance).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    @DisplayName("랜덤 값에 의한 멈춤 테스트")
    fun stopCarByValue(moveValue: Int) {
        car.moveByValue(moveValue)
        assertThat(car.distance).isEqualTo(0)
    }

    @Test
    @DisplayName("자동차의 현재 정보 출력 테스트")
    fun showCarInfoTest() {
        car.moveByValue(1)
        car.moveByValue(9)
        car.moveByValue(8)
        assertThat(car.toString()).isEqualTo("테스트 : --")
    }
}

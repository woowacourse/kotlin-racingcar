package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setup() {
        car = Car("pobi")
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `진행 조건이 성립할 때 앞으로 움직였는지`(inout: Int) {
        car.move(inout)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `진행 조건이 성립하지 않을 때 멈췄는지`(inout: Int) {
        car.move(inout)

        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "   ", "    "])
    fun `이름 포맷이 적절하지 않을 때 예외를 던지는 지`(input: String) {
        assertThrows<IllegalArgumentException> { Car(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "laco-dev", "joonkyung"])
    fun `이름 길이가 적절하지 않을 때 예외를 던지는 지`(input: String) {
        assertThrows<IllegalArgumentException> { Car(input) }
    }
}

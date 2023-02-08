package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class CarTest {
    @Test
    fun `Car 객체 생성이 잘 되는지 확인`() {
        val car = Car("hihi")
        assertThat(car.name).isEqualTo("hihi")
        assertThat(car.location).isEqualTo(0)
    }

    @ParameterizedTest(name = "숫자가 4 이하인 경우 이동하지 않는지 확인. {argumentsWithNames}")
    @ValueSource(ints = [0, 1, 2, 3])
    fun `숫자가 4 이하인 경우 이동하지 않는지 확인`(input: Int) {
        val car = Car("hihi")
        car.plusLocation(input)
        assertThat(car.location).isEqualTo(0)
    }

    @ParameterizedTest(name = "숫자가 4 이하인 경우 이동하는지 확인. {argumentsWithNames}")
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `숫자가 4 이상인 경우 이동하는지 확인`(input: Int) {
        val car = Car("hihi")
        car.plusLocation(input)
        assertThat(car.location).isEqualTo(1)
    }

    @ParameterizedTest(name = "잘못된 입력일 경우 에러 메시지 발생 {argumentsWithNames}")
    @ValueSource(ints = [-1, 10])
    fun `잘못된 입력일 경우`(input: Int) {
        val car = Car("hihi")
        assertThrows<IllegalArgumentException> {
            car.plusLocation(input)
        }
    }
}

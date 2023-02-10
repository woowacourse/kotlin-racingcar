package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class CarTest {
    @ParameterizedTest(name = "Car 객체 이름은 1자 이상 5자 이하는 정상 작동한다 {argumentsWithNames}")
    @ValueSource(strings = ["1", "12345"])
    fun `Car 객체 이름은 1자 이상 5자 이하는 정상 작동한다`(input: String) {
        assertDoesNotThrow { Car(input) }
    }

    @ParameterizedTest(name = "Car 객체의 이름은 1자 이상 5자 이하 이외에는 에러가 난다 {argumentsWithNames}")
    @ValueSource(strings = ["", "123456"])
    fun `Car 객체의 이름은 1자 이상 5자 이하 이외에는 에러가 난다`(input: String) {
        assertThrows<IllegalArgumentException> { Car(input) }
    }

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
        car.move(input)
        assertThat(car.location).isEqualTo(0)
    }

    @ParameterizedTest(name = "숫자가 4 이하인 경우 이동하는지 확인. {argumentsWithNames}")
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `숫자가 4 이상인 경우 이동하는지 확인`(input: Int) {
        val car = Car("hihi")
        car.move(input)
        assertThat(car.location).isEqualTo(1)
    }

    @ParameterizedTest(name = "0~9이외 수 입력 시 오류 발생 {argumentsWithNames}")
    @ValueSource(ints = [-1, 10])
    fun `0~9이외 수 입력 시 오류 발생`(input: Int) {
        val car = Car("hihi")
        assertThrows<IllegalArgumentException> {
            car.move(input)
        }
    }
}

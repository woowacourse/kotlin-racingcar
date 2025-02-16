import model.Car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\t", "\n"])
    fun `자동차 이름이 공백일 경우 예외가 발생한다`(value: String) {
        assertThrows<IllegalArgumentException> { Car(value.trim()) }
    }

    @Test
    fun `자동차 이름이 5자를 초과할 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { Car("123456") }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `무작위 값이 4 미만이면 자동차가 전진하지 않는다`(value: Int) {
        val car = Car("A")
        car.move(value)
        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `무작위 값이 4 이상이면 자동차가 전진한다`(value: Int) {
        val car = Car("A")
        car.move(value)
        assertThat(car.position).isEqualTo(1)
    }
}

package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ValueSource(ints = [4, 9])
    @ParameterizedTest
    fun `자동차는 4 이상의 숫자에서 전진한다`(int: Int) {
        val car = Car("Test")
        car.move(int)
        assertThat(car.distance).isEqualTo(1)
    }

    @ValueSource(ints = [0, 3])
    @ParameterizedTest
    fun `자동차는 4 이상의 숫자에서 정지한다`(int: Int) {
        val car = Car("Test")
        car.move(int)
        assertThat(car.distance).isEqualTo(0)
    }

    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        val userInputExample = "자동차,이름은,쉼표로,구분한다"
        val cars = userInputExample.toCars()
        assertThat(cars.map { car: Car -> car.name }).isEqualTo(listOf("자동차", "이름은", "쉼표로", "구분한다"))
    }
}

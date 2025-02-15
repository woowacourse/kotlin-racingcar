package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차는 전진한다`() {
        val car = Car("Test")
        car.move()
        assertThat(car.distance).isEqualTo(1)
    }

    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        val userInputExample = "자동차,이름은,쉼표로,구분한다"
        val cars = userInputExample.toCars()
        assertThat(cars.map { car: Car -> car.name }).isEqualTo(listOf("자동차", "이름은", "쉼표로", "구분한다"))
    }
}

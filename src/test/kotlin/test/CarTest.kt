package test

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4 이상의 값이라면 자동차는 한칸 전진한다`(number: Int) {
        val car = Car("Test")
        car.move(number)
        Assertions.assertThat(car.distance == 1).isTrue
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `4 미만의 값이라면 자동차는 정지한다`(number: Int) {
        val car = Car("Test")
        car.move(number)
        Assertions.assertThat(car.distance == 0).isTrue
    }

    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        Assertions
            .assertThatThrownBy { Car("5자 이상의 자동차 이름") }
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.")
    }
}

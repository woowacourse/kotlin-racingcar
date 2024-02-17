package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n", "    "])
    fun `자동차 이름은 공백을 허용하지 않는다`(input: String) {
        assertThatThrownBy {
            Car(input, RandomNumberGenerator)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 공백을 허용하지 않습니다")
    }

    @ParameterizedTest
    @ValueSource(strings = ["shimji", "pangtae", "abcdefggeg"])
    fun `자동차 이름은 5자 이하여야 한다`(input: String) {
        assertThatThrownBy {
            Car(input, RandomNumberGenerator)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 다섯글자 이하여야 합니다")
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `0 부터 3 사이이면 자동차가 움직이지 않는다`(input: Int) {
        // given
        val car = Car("shim", ExplicitNumberGenerator(input))
        // when
        car.moveIfPossible()
        assertThat(car.position == 0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4 이상 9 이하이면 자동차가 움직인다`(input: Int) {
        // given
        val car = Car("shim", ExplicitNumberGenerator(input))
        // when
        car.moveIfPossible()
        assertThat(car.position == 1)
    }
}

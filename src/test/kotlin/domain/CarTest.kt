package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5])
    fun `무작위 값이 4 이상인 경우, 자동차는 전진한다`(num: Int) {
        val car = Car("test")
        car.move(num)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [3])
    fun `무작위 값이 4 미만인 경우, 자동차는 전진하지 않는다`(num: Int) {
        val car = Car("test")
        car.move(num)
        assertThat(car.position).isEqualTo(0)
    }
}

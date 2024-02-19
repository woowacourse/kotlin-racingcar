package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차는 숫자가 4이상인 경우 이동합니다`() {
        val car = Car("test")

        car.move(1)
        assertThat(car.position).isEqualTo(0)
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }
}

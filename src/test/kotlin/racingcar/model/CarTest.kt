package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {
    /** ForwardService Test */
    @Test
    fun `Car에 randomNumber가 4 이상일 경우 전진하는지 확인한다`() {
        // given
        val car = Car("olive")
        val initialPosition = car.position

        // when
        car.tryForward(4)

        // then
        Assertions.assertThat(car.position).isEqualTo(initialPosition + 1)
    }

    @Test
    fun `Car에 randomNumber가 4 미만일 경우 전진하지 않는지 확인한다`() {
        // given
        val car = Car("olive")
        val initialPosition = car.position

        // when
        car.tryForward(0)

        // then
        Assertions.assertThat(car.position).isEqualTo(initialPosition)
    }
}

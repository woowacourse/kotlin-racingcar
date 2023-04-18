package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `이름이 5글자를 초과하면 예외를 반환한다`() {
        assertThrows<IllegalArgumentException> { Car("하티하티하티") }
    }

    @Test
    fun `4 이상의 값을 받으면 position을 1 증가시킨다`() {
        val car = Car("하티")

        car.move(4)

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `4 미만의 값을 받으면 position을 변화 시키지않는다`() {
        val car = Car("하티")

        car.move(3)

        assertThat(car.position).isEqualTo(0)
    }
}


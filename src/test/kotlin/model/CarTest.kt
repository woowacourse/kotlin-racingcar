package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `전진 기능 테스트`() {
        val car = Car("서기")
        car.moveForward(true)
        car.moveForward(false)
        car.moveForward(true)

        assertThat(car.getForwardCount()).isEqualTo(2)
    }
}
package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `moveForward 메서드 인자값에 따른 car 위치 정보 테스트`() {
        val car = Car("서기")
        isMoveExample.forEach { car.moveForward(it) }

        assertThat(car.forwardCount).isEqualTo(2)
    }

    companion object {
        val isMoveExample = listOf(true, false, true)
    }
}

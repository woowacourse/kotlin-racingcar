package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차가 두 칸 이동한 경우 전진 수는 2다`() {
        val car = Car("서기")
        isMoveExample.forEach { car.moveForward(it) }

        assertThat(car.forwardCount).isEqualTo(2)
    }

    companion object {
        val isMoveExample = listOf(true, false, true)
    }
}
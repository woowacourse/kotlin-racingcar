package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {

    @ParameterizedTest
    @CsvSource("true,1", "false,0")
    fun `moveForward 메서드 인자값에 따른 car 위치 정보 테스트`(isMove: Boolean, forwardCount: Int) {
        val car = Car("서기")
        car.moveForward(isMove)

        assertThat(car.forwardCount).isEqualTo(forwardCount)
    }
}

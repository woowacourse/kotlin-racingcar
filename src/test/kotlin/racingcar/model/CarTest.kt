package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 이동 테스트 - 성공`() {
        val myCar = Car("eddy")
        myCar.move(1)
        assertThat(myCar.distance).isEqualTo(1)
    }

    @Test
    fun `자동차 이동 테스트 - 실패`() {
        val myCar = Car("eddy")
        myCar.move(1)
        assertThat(myCar.distance).isNotEqualTo(0)
    }
}

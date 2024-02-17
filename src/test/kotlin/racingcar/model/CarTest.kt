package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차가 있을 때, 한칸 이동시키면, 자동차의 거리는 1이 된다`() {
        // given
        val myCar = Car("eddy")

        // when
        myCar.move(1)

        // then
        assertThat(myCar.distance).isEqualTo(1)
    }

    @Test
    fun `자동차가 있을 때, 0칸 이동시키면, 자동차의 거리는 변화지 않는다`() {
        // given
        val myCar = Car("eddy")

        // when
        myCar.move(0)

        // then
        assertThat(myCar.distance).isEqualTo(0)
    }
}

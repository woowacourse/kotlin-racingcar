package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MovingDiscriminatorTest {

    @Test
    fun `4이상이면 전진한다 범위(4~9)`() {
        Assertions.assertThat(
            MovingDiscriminator.checkGoingForward(4),
        ).isTrue
    }

    @Test
    fun `3이하이면 전진하지 않는다(0~3)`() {
        Assertions.assertThat(
            MovingDiscriminator.checkGoingForward(3),
        ).isFalse
    }
}

package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MovingDiscriminatorTest {

    @Test
    fun `4이상이면 전진한다`() {
        Assertions.assertThat(
            MovingDiscriminator.checkGoingForward(4),
        ).isTrue
    }

    @Test
    fun `3이하이면 전진하지 않는다`() {
        Assertions.assertThat(
            MovingDiscriminator.checkGoingForward(3),
        ).isFalse
    }
}

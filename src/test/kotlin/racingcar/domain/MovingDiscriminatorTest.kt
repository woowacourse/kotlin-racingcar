package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MovingDiscriminatorTest {

    @Test
    fun `숫자 4를 받았을때 전진하는지 확인하는 테스트(4부터 9까지 전진)`() {
        Assertions.assertThat(
            MovingDiscriminator.checkGoingForward(4),
        ).isTrue
    }

    @Test
    fun `숫자 3을 받았을때 전진하지 않는지 확인하는 테스트(0부터 3까지 전진하지 않음)`() {
        Assertions.assertThat(
            MovingDiscriminator.checkGoingForward(3),
        ).isFalse
    }
}

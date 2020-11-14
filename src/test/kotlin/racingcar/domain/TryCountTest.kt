package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class TryCountTest {
    @Test
    internal fun init() {
        assertDoesNotThrow { TryCount(1) }
        assertThatIllegalArgumentException().isThrownBy { TryCount(0) }
    }

    @Test
    internal fun minus() {
        val tryCount = TryCount(1)
        tryCount.minus()
        assertThat(tryCount.isPresent).isFalse
    }
}


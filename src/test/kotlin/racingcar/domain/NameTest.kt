package racingcar.domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class NameTest {

    @Test
    fun longName() {
        val value = "summer"

        assertThatIllegalArgumentException().isThrownBy { Name(value) }
    }

    @Test
    fun `blank Name`() {
        val value = ""

        assertThatIllegalArgumentException().isThrownBy { Name(value) }
    }
}

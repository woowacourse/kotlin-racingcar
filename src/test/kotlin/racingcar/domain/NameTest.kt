package racingcar.domain

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NameTest {

    @Test
    fun longName() {
        val value = "summer"

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Name(value) }
    }

    @Test
    fun `blank Name`() {
        val value = ""

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Name(value) }
    }
}
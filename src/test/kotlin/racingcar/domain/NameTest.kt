package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameTest {

    @Test
    fun longName() {
        val value = "summer"

        assertThrows <IllegalArgumentException> { Name(value) }
    }

    @Test
    fun `blank Name`() {
        val value = ""

        assertThrows <IllegalArgumentException> { Name(value) }
    }
}

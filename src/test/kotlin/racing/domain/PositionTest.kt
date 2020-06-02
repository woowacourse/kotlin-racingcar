package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PositionTest {
    private val position: Position = Position()

    @Test
    internal fun `initial value is 0`() {
        assertThat(position.value).isEqualTo(0)
    }

    @Test
    internal fun `value changes after moveForward`() {
        assertThat(position.moveForward().value).isEqualTo(1)
    }

    @Test
    internal fun `equality as a value object`() {
        val other = Position()
        assertThat(other).isEqualTo(position)
        assertThat(other.moveForward()).isEqualTo(position.moveForward())
    }
}

package study

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test


internal class TestTest {
    @Test
    fun `test`() {
        assertThat(" ".isEmpty()).isTrue()
    }
}
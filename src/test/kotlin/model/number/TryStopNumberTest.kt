package model.number

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TryStopNumberTest {
    @Test
    fun `난수 생성기 테스트`() {
        val actual = (0..3)
        assertThat(RandomNumber().generate() in actual)
    }
}

package model.number

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TryMoveNumberTest {
    @Test
    fun `난수 생성기 테스트`() {
        val actual = (4..9)
        assertThat(RandomNumber().generate() in actual)
    }
}

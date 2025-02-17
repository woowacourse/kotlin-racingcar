package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TrimTest {
    @Test
    fun `String사이 공백도 사라지는지 테스트`() {
        val names = "   동전 제리   "
        val actual = "동전 제리"
        assertThat(actual).isEqualTo(names.trim())
    }
}

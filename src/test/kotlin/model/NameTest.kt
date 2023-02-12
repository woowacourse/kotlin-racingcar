package model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameTest {
    @Test
    fun `이름이 5자 초과 시 에러를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Name("aaaaaa")
        }
    }

    @Test
    fun `이름에 한글이 들어갈 시 에러를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Name("케이")
        }
    }

    @Test
    fun `이름에 특수부호가 들어갈 시 에러를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Name("..")
        }
    }
}

package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameTest {

    @Test
    fun `이름이 5글자를 초과하면 예외를 반환한다`() {
        assertThrows<IllegalArgumentException> { Name("하티하티하티") }
    }
}

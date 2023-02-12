package racingcar.entity

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class NameTest {
    @Test
    fun `글자수가 1글자 미만인 이름은 IllegalArgumentException을 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            Name("")
        }
    }

    @Test
    fun `글자수가 5글자 초과인 이름은 IllegalArgumentException을 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            Name("123456")
        }
    }
}
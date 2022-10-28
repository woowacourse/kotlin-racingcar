package racingcar.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Name

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "123456"])
    fun 이름의_길이는_1자이상_5자이하가_아니면_예외를_반환한다(name: String) {

        assertThrows<IllegalArgumentException> {
            Name(name)
        }
    }
}

package racingCar.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class NameTest {

    @ParameterizedTest(name = "잘못된 값이 들어오면 예외가 발생한다.")
    @ValueSource(strings = ["", "aaaaaaa"])
    fun exceptionNameTest(name: String) {
        assertThrows<IllegalArgumentException>("이름을 다시 입력해주세요") {
            Name(name)
        }
    }

    @ParameterizedTest(name = "옳바른 값이 들어오면 Name 이 생성된다.")
    @ValueSource(strings = ["제이슨", "링링"])
    fun validNameTest(name: String) {
        assertDoesNotThrow { Name(name) }
    }
}

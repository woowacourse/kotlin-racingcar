package racingcar.model.car

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarNameTest {

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1", "22", "333", "4444",
            "55555", "  55555", "55555 ",
            "  55555   ", "buna", "woogi", "java"
        ]
    )
    fun `양 옆 공백을 제외한 이름이 1글자 이상 5글자 미만일 때, CarName 객체 생성시, 예외가 발생하지 않는다`(name: String) {
        assertDoesNotThrow {
            CarName(name)
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "", "       ", "kotlin", "soodal",
            "godobject", "mockito", "testcode"
        ]
    )
    fun `양 옆 공백을 제외한 이름이 공백이거나 5글자 초과일 때, CarName 객체 생성시, IllegalArgumentException가 발생한다`(name: String) {
        assertThrows<IllegalArgumentException> {
            CarName(name)
        }
    }
}

package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car

class CarTest {
    @DisplayName("자동차 이름을 작성하지 않았을 때")
    @Test
    fun inputIsEmpty() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @DisplayName("자동차 이름 길이가 1자 미만 5자 초과일 때")
    @ParameterizedTest
    @ValueSource(strings = ["", "crongcrong"])
    fun outOfRangeNameLength(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @DisplayName("자동차 이름 안에 공백이 있는 경우")
    @Test
    fun inputContainsSpace() {
        assertThrows<IllegalArgumentException> {
            Car("he na")
        }
    }
}

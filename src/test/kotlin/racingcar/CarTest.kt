package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
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

    @DisplayName("전진 조건 4 이상 일 때 - 전진")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 9])
    fun move(randomNumber: Int) {
        val expectedResult = 1
        val result = Car("hye").move(randomNumber)

        assertEquals(expectedResult, result)
    }

    @DisplayName("전진 조건 4 미만 일 때 - 정지")
    @ParameterizedTest
    @ValueSource(ints = [0, 2, 3])
    fun stop(randomNumber: Int) {
        val expectedResult = 0
        val result = Car("hye").move(randomNumber)

        assertEquals(expectedResult, result)
    }
}

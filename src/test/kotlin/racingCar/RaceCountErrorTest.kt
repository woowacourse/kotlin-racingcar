package racingCar

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RaceCountErrorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", ",", "#4#", "bb"])
    fun `자동차 경주 횟수가 숫자가 아닌 값을 입력 받았을 때 에러를 발생시킨다`(raceCount: String) {
        // then:
        assertThrows<IllegalArgumentException> { RaceCountError.validate(raceCount) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "5", "1344", "32"])
    fun `자동차 경주 횟수가 숫자인 값을 입력 받을 때 에러를 발생시키지 않는다`(raceCount: String) {
        // then:
        assertDoesNotThrow { RaceCountError.validate(raceCount) }
    }
}

package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.controller.Race

class RaceTest {
    private val race = Race()

    @Test
    fun inputNone() {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.validateNames(emptyList())
            }

        assertEquals(
            ERROR_REQUEST_INPUT,
            exception.message,
        )
    }

    @Test
    fun inputLessThanTwo() {
        val names = listOf("lisa")
        val exception =
            assertThrows<IllegalArgumentException> {
                race.validateNames(names)
            }

        assertEquals(
            ERROR_CAR_LESS_THAN_TWO,
            exception.message,
        )
    }

    @Test
    fun inputGreaterThanTwenty() {
        val names =
            listOf(
                "crong", "lisa", "hena", "pobi", "poro", "lufy", "joro", "sang", "frank", "usop",
                "nami", "zzang", "huni", "chul", "yuri", "meang", "chae", "miri", "won", "shin", "bong", "siro",
            )
        val exception =
            assertThrows<IllegalArgumentException> {
                race.validateNames(names)
            }

        assertEquals(
            ERROR_CAR_GREATER_THAN_TWENTY,
            exception.message,
        )
    }

    @Test
    fun inputDuplicatedName() {
        val names = listOf("crong", "crong")
        val exception =
            assertThrows<IllegalArgumentException> {
                race.validateNames(names)
            }

        assertEquals(
            ERROR_NAME_DUPLICATION,
            exception.message,
        )
    }

    @Test
    fun exceedIntRangeRoundNumber() {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.checkRoundNumber("35035810684041351035")
            }
        assertEquals(
            ERROR_INPUT_NUMBER_ONLY,
            exception.message,
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "가", "ab", "가나", "?"])
    fun inputLetterForRoundNumber(roundNumber: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.checkRoundNumber(roundNumber)
            }
        assertEquals(
            ERROR_INPUT_NUMBER_ONLY,
            exception.message,
        )
    }

    @Test
    fun inputEmptyRoundNumber() {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.checkRoundNumber("")
            }
        assertEquals(
            ERROR_INPUT_NUMBER_ONLY,
            exception.message,
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1"])
    fun inputLessThanOneRoundNumber(roundNumber: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.getValidRoundNumber(roundNumber)
            }
        assertEquals(
            ERROR_ROUND_LESS_THAN_ONE,
            exception.message,
        )
    }

    companion object {
        const val ERROR_REQUEST_INPUT = "[Error] 값을 입력해 주세요"
        const val ERROR_CAR_LESS_THAN_TWO = "[Error] 자동차 이름은 2대 이상 입력해 주세요."
        const val ERROR_CAR_GREATER_THAN_TWENTY = "[Error] 자동차 이름은 20대 이하로 입력해 주세요."
        const val ERROR_NAME_DUPLICATION = "[Error] 중복된 자동차 이름은 작성할 수 없습니다."
        const val ERROR_ROUND_LESS_THAN_ONE = "[Error] 1회 이상 입력해 주세요."
        const val ERROR_INPUT_NUMBER_ONLY = "[Error] 숫자만 입력해 주세요."
    }
}

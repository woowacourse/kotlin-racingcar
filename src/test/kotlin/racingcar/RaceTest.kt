package racingcar

import org.assertj.core.api.Assertions.assertThat
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

        assertThat(exception.message.equals(ERROR_REQUEST_INPUT))
    }

    @Test
    fun inputLessThanTwo() {
        val names = listOf("lisa")
        val exception =
            assertThrows<IllegalArgumentException> {
                race.validateNames(names)
            }

        assertThat(exception.message.equals(ERROR_CAR_LESS_THAN_TWO))
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

        assertThat(exception.message.equals(ERROR_CAR_GREATER_THAN_TWENTY))
    }

    @Test
    fun inputDuplicatedName() {
        val names = listOf("crong", "crong")
        val exception =
            assertThrows<IllegalArgumentException> {
                race.validateNames(names)
            }

        assertThat(exception.message.equals(ERROR_NAME_DUPLICATION))
    }

    @Test
    fun exceedIntRangeRoundNumber() {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.getValidRoundNumber("35035810684041351035")
            }

        assertThat(exception.message.equals(ERROR_INPUT_NUMBER_ONLY))
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "가", "ab", "가나", "?"])
    fun inputLetterForRoundNumber(roundNumber: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.getValidRoundNumber(roundNumber)
            }

        assertThat(exception.message.equals(ERROR_INPUT_NUMBER_ONLY))
    }

    @Test
    fun inputEmptyRoundNumber() {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.getValidRoundNumber("")
            }

        assertThat(exception.message.equals(ERROR_INPUT_NUMBER_ONLY))
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "-918275817"])
    fun inputLessThanOneRoundNumber(roundNumber: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.getValidRoundNumber(roundNumber)
            }

        assertThat(exception.message.equals(ERROR_ROUND_LESS_THAN_ONE))
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

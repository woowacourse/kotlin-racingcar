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
            ERROR_MESSAGE,
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
            ERROR_MESSAGE,
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
            ERROR_MESSAGE,
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
            ERROR_MESSAGE,
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
            ERROR_MESSAGE,
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
            ERROR_MESSAGE,
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
            ERROR_MESSAGE,
            exception.message,
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "-9182758172598719587"])
    fun inputLessThanOneRoundNumber(roundNumber: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                race.getValidRoundNumber(roundNumber)
            }
        assertEquals(
            ERROR_MESSAGE,
            exception.message,
        )
    }

    companion object {
        const val ERROR_MESSAGE = "잘못된 입력입니다."
    }
}

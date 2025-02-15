@file:Suppress("ktlint:standard:no-wildcard-imports")

package racingcar

import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car

class InputValidatorTest {
    private lateinit var inputValidator: InputValidator

    @BeforeEach
    fun setUp() {
        inputValidator = InputValidator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "12345678"])
    @DisplayName("올바른 경주 횟수 검증")
    fun validateValidRaceCount(raceCount: String) {
        assertDoesNotThrow {
            inputValidator.validRaceCountChecker(raceCount)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "0", "-1", "한번", "one", " 1", "123456789"])
    @DisplayName("잘못된 경주 횟수 검증")
    fun validateInvalidRaceCount(raceCount: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validRaceCountChecker(raceCount)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["eng", "Eng", "한글", "12345", "공 백포함", "문자다섯개", "차 c1A"])
    @DisplayName("올바른 자동차 이름 검증")
    fun validateValidCarNames(carName: String) {
        assertDoesNotThrow {
            inputValidator.validCarNameChecker(carName)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\t", "\n", " 앞공백", "뒤공백 ", "다섯글자초과", "특@문", "ㅊㅗ성"])
    @DisplayName("잘못된 자동차 이름 검증")
    fun validateInvalidCarNames(carName: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validCarNameChecker(carName)
        }
    }

    @Test
    @DisplayName("올바른 자동차 이동 판정 랜덤값 체크")
    fun validateValidCarMoveValue() {
        for (raceCount in 0..9) {
            assertDoesNotThrow {
                inputValidator.possibleMoveValueCheck(raceCount)
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 10])
    @DisplayName("잘못된 자동차 이동 판정 랜덤값 체크")
    fun validateInvalidCarMoveValue(raceCount: Int) {
        assertThrows<IllegalArgumentException> {
            inputValidator.possibleMoveValueCheck(raceCount)
        }
    }

    @Test
    @DisplayName("이름이 중복 되지 않은 자동차 리스트")
    fun validateNotDuplicateCarName() {
        val cars = listOf(Car("a", inputValidator), Car("b", inputValidator))
        assertDoesNotThrow {
            inputValidator.duplicateCarNameCheck(cars)
        }
    }

    @Test
    @DisplayName("이름이 중복된 자동차 리스트")
    fun validateDuplicateCarName() {
        val cars = listOf(Car("a", inputValidator), Car("a", inputValidator))
        assertThrows<IllegalArgumentException> {
            inputValidator.duplicateCarNameCheck(cars)
        }
    }
}

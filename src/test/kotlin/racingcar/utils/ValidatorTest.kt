package racingcar.utils

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ValidatorTest {

    private lateinit var validator: Validator

    @BeforeEach
    fun beforeEach() {
        this.validator = Validator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["sooda, buna", "sooda,buna", "   sooda,  buna  "])
    fun `자동차 이름 검증 노말 테스트`(input: String) {
        assertDoesNotThrow {
            validator.checkCarNames(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["soodal, buna", "sooda, sooda", "", ",", "buna, "])
    fun `자동차 이름 검증 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            validator.checkCarNames(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", Int.MAX_VALUE.toString(), "5", "6"])
    fun `시도 횟수 노말 테스트`(input: String) {
        assertDoesNotThrow {
            validator.checkRoundCount(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", (Int.MAX_VALUE.toLong() + 1).toString(), "-1", "*", "", "otter", "buna"])
    fun `시도 횟수 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            validator.checkRoundCount(input)
        }
    }
}
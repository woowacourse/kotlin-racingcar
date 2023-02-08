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
    fun `자동차 이름 검증 해피 테스트`(input: String) {
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
}

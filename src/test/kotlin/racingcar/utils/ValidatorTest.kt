package racingcar.utils

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.controller.ViewController

internal class ValidatorTest {

    private lateinit var validator: RacingRuleValidator
    private lateinit var viewController: ViewController

    @BeforeEach
    fun beforeEach() {
        this.validator = RacingRuleValidator()
        viewController = ViewController()
    }

    @ParameterizedTest
    @ValueSource(strings = ["sooda, buna", "sooda,buna", "   sooda,  buna  "])
    fun `자동차 이름 중복 정상 테스트`(input: String) {
        assertDoesNotThrow {
            val names = TextUtils.removeTextsBlank(input.split(TEXT_IN_LINE_DELIMITER))

            require(validator.isValidateNotDuplicatedCarNames(names))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["soodal, soodal", "buna,  buna"])
    fun `자동차 이름 중복 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            val names = TextUtils.removeTextsBlank(input.split(TEXT_IN_LINE_DELIMITER))

            require(validator.isValidateNotDuplicatedCarNames(names))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", Int.MAX_VALUE.toString(), "5", "6"])
    fun `시도 횟수 정상 테스트`(input: String) {
        assertDoesNotThrow {
            require(validator.isValidateRoundCountBoundary(input.toInt()))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", (Int.MAX_VALUE.toLong() + 1).toString(), "-1", "*", "", "otter", "buna"])
    fun `시도 횟수 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            require(validator.isValidateRoundCountBoundary(input.toInt()))
        }
    }
}

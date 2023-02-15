package racingcar.utils

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.controller.ViewController

internal class RacingRuleValidatorTest {

    private lateinit var racingRuleValidator: RacingRuleValidator
    private lateinit var viewController: ViewController

    @BeforeEach
    fun beforeEach() {
        this.racingRuleValidator = RacingRuleValidator()
        viewController = ViewController()
    }

    @ParameterizedTest
    @ValueSource(strings = ["sooda, buna", "sooda,buna", "   sooda,  buna  "])
    fun `자동차 이름이 중복되지 않을 때 에러가 발생하지 않습니다`(input: String) {
        assertDoesNotThrow {
            val names = TextUtils.removeTextsBlank(input.split(TEXT_IN_LINE_DELIMITER))

            require(racingRuleValidator.isValidateNotDuplicatedCarNames(names))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["soodal, soodal", "buna,  buna"])
    fun `자동차 이름이 중복될 때 에러가 발생합니다`(input: String) {
        assertThrows<IllegalArgumentException> {
            val names = TextUtils.removeTextsBlank(input.split(TEXT_IN_LINE_DELIMITER))

            require(racingRuleValidator.isValidateNotDuplicatedCarNames(names))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", Int.MAX_VALUE.toString()])
    fun `시도 횟수가 1 이상, Int의 양수 범위 이하인 숫자일 때 에러가 발생하지 않습니다`(input: String) {
        assertDoesNotThrow {
            require(racingRuleValidator.isValidateRoundCountBoundary(input.toInt()))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", (Int.MAX_VALUE.toLong() + 1).toString()])
    fun `시도 횟수가 1이상, Int 양수 범위 이하에 속하지 않을 때 에러가 발생합니다`(input: String) {
        assertThrows<IllegalArgumentException> {
            require(racingRuleValidator.isValidateRoundCountBoundary(input.toInt()))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["*", "buna"])
    fun `시도 횟수가 숫자가 아닐 때 에러가 발생합니다`(input: String) {
        assertThrows<IllegalArgumentException> {
            require(racingRuleValidator.isValidateRoundCountBoundary(input.toInt()))
        }
    }
}

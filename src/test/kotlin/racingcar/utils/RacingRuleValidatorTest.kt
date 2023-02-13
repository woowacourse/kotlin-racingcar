package racingcar.utils

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingRuleValidatorTest {

    private lateinit var racingRuleValidator: RacingRuleValidator

    @BeforeEach
    fun beforeEach() {
        this.racingRuleValidator = RacingRuleValidator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["sooda, buna", "sooda,buna", "   sooda,  buna  "])
    fun `자동차 이름이 중복되지 않을 때 자동차 리스트가 생성됩니다`(input: String) {
        assertDoesNotThrow {
            val names = TextUtils.removeTextsBlank(input.split(TEXT_IN_LINE_DELIMITER))

            require(racingRuleValidator.isValidateNotDuplicatedCarNames(names))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["soodal, soodal", "buna,  buna"])
    fun `자동차 이름이 중복될 때 자동차 리스트 생성을 하지 않습니다`(input: String) {
        assertThrows<IllegalArgumentException> {
            val names = TextUtils.removeTextsBlank(input.split(TEXT_IN_LINE_DELIMITER))

            require(racingRuleValidator.isValidateNotDuplicatedCarNames(names))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", Int.MAX_VALUE.toString(), "5", "6"])
    fun `시도 횟수가 1 ~ 2,147,483,647인 숫자일 때 예외가 발생하지 않는다`(input: String) {
        assertDoesNotThrow {
            require(racingRuleValidator.isValidateRoundCountBoundary(input.toInt()))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", (Int.MAX_VALUE.toLong() + 1).toString(), "-1", "*", "", "otter", "buna"])
    fun `시도 횟수가 숫자가 아니거나 1 ~ 2,147,483,647에 속하지 않을 때 예외가 발생한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            require(racingRuleValidator.isValidateRoundCountBoundary(input.toInt()))
        }
    }
}

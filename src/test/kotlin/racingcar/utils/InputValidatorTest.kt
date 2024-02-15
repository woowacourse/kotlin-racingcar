package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import racingcar.constants.Constants.DUPLICATED_NAME_EXCEPTION
import racingcar.constants.Constants.INVALID_NAME_SIZE_EXCEPTION
import racingcar.constants.Constants.INVALID_NUM_OF_CARS_EXCEPTION
import racingcar.constants.Constants.INVALID_TRIAL_NUM_RANGE_EXCEPTION
import racingcar.constants.Constants.INVALID_TRIAL_NUM_TYPE_EXCEPTION

@DisplayName("InputValidatorTest 클래스")
class InputValidatorTest {
    @Nested
    inner class `자동차 이름 유효성 메소드 getValidatedNames 테스트` {
        @Test
        fun `정상적으로 입력하여 문자열의 리스트를 반환`() {
            val input = "bingt,k ,@@,123 ,우테코"

            // list of String
            val actualOutput: List<String> = InputValidator.getValidatedNames(input)
            val expectedOutput: List<String> = listOf(
                "bingt", "k", "@@", "123", "우테코"
            )
            assertThat(actualOutput).isEqualTo(expectedOutput)
        }

        @Test
        fun `Empty인 문자열을 입력했을 때, 예외를 발생시킴`() {
            try {
                val input = ",,,,"
                val actualOutput = InputValidator.getValidatedNames(input)
            } catch (e: IllegalArgumentException) {
                Assertions.assertEquals(INVALID_NAME_SIZE_EXCEPTION, e.message)
            }
        }

        @Test
        fun `Blank인 문자열을 입력했을 때, 예외를 발생시킴`() {
            try {
                val input = ", ,  ,   "
                val actualOutput = InputValidator.getValidatedNames(input)
            } catch (e: IllegalArgumentException) {
                Assertions.assertEquals(INVALID_NAME_SIZE_EXCEPTION, e.message)
            }
        }

        @Test
        fun `중복된 값을 입력했을 때, 예외를 발생시킴`() {
            testExceptions(
                input = "kkm,kkm,kkm",
                exceptionMessage = DUPLICATED_NAME_EXCEPTION,
                getValidatedInput = InputValidator::getValidatedNames
            )
        }

        @Test
        fun `2개 미만의 값을 입력하였을 때, 예외를 발생시킴`() {
            testExceptions(
                input = "kkm",
                exceptionMessage = INVALID_NUM_OF_CARS_EXCEPTION,
                getValidatedInput = InputValidator::getValidatedNames
            )
        }
    }

    @Nested
    inner class `레이싱 게임 시도 횟수 유효성 메소드 getValidatedTrialNum 테스트` {
        @Test
        fun `정상적으로 입력하여 정수를 반환`() {
            val input = "5"
            val actualOutput: Int = InputValidator.getValidatedTrialNum(input)
            val expectedOutput = 5
            assertThat(actualOutput).isEqualTo(expectedOutput)
        }

        @Test
        fun `시도 횟수로 숫자가 아닌 문자가 입력됐을 때, 예외를 발생시킴`() {
            testExceptions(
                input = "안녕하세요",
                exceptionMessage = INVALID_TRIAL_NUM_TYPE_EXCEPTION,
                getValidatedInput = InputValidator::getValidatedTrialNum
            )
        }

        @Test
        fun `시도 횟수로 정수의 범위를 벗어나는 수가 입력됐을 때, 예외를 발생시킴`() {
            testExceptions(
                input = "2147483648",
                exceptionMessage = INVALID_TRIAL_NUM_TYPE_EXCEPTION,
                getValidatedInput = InputValidator::getValidatedTrialNum
            )
        }

        @Test
        fun `시도 횟수로 float이 입력됐을 때, 예외를 발생시킴`() {
            testExceptions(
                input = "1.5",
                exceptionMessage = INVALID_TRIAL_NUM_TYPE_EXCEPTION,
                getValidatedInput = InputValidator::getValidatedTrialNum
            )
        }

        @Test
        fun `시도 횟수로 0이 입력됐을 때, 예외를 발생시킴`() {
            testExceptions(
                input = "0",
                exceptionMessage = INVALID_TRIAL_NUM_RANGE_EXCEPTION,
                getValidatedInput = InputValidator::getValidatedTrialNum
            )
        }

        @Test
        fun `시도 횟수로 음수가 입력됐을 때, 예외를 발생시킴`() {
            testExceptions(
                input = "-5",
                exceptionMessage = INVALID_TRIAL_NUM_RANGE_EXCEPTION,
                getValidatedInput = InputValidator::getValidatedTrialNum
            )
        }
    }

    private fun <T> testExceptions(
        input: String,
        exceptionMessage: String,
        getValidatedInput: (String) -> T
    ) {
        try {
            val actualOutput = getValidatedInput(input)
        } catch (e: IllegalArgumentException) {
            Assertions.assertEquals(exceptionMessage, e.message)
        }
    }
}
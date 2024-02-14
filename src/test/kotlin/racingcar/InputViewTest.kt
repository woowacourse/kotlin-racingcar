package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    @Test
    fun `자동차들의 이름을 정상적으로 입력하여 문자열의 리스트를 반환`() {
        val input = "bingt,k ,@@,123 ,우테코"

        // list of String
        val actualOutput: List<String> = InputView.getValidatedNames(input)
        val expectedOutput: List<String> = listOf(
            "bingt", "k", "@@", "123", "우테코"
        )
        assertThat(actualOutput).isEqualTo(expectedOutput)
    }

    @Test
    fun `Empty인 문자열을 자동차명으로 입력했을 때, 예외를 발생시킴`() {
        try {
            val input = ",,,,"
            val actualOutput = InputView.getValidatedNames(input)
        } catch (e: IllegalArgumentException) {
            Assertions.assertEquals(INVALID_NAME_SIZE_EXCEPTION, e.message)
        }
    }

    @Test
    fun `Blank인 문자열을 자동차명으로 입력했을 때, 예외를 발생시킴`() {
        try {
            val input = ", ,  ,   "
            val actualOutput = InputView.getValidatedNames(input)
        } catch (e: IllegalArgumentException) {
            Assertions.assertEquals(INVALID_NAME_SIZE_EXCEPTION, e.message)
        }
    }

    @Test
    fun `중복된 자동차명을 입력했을 때, 예외를 발생시킴`() {
        testExceptions(
            input = "kkm,kkm,kkm",
            exceptionMessage = DUPLICATED_NAME_EXCEPTION,
            getValidatedInput = InputView::getValidatedNames
        )
    }

    @Test
    fun `자동차 이름으로 2개 미만을 입력하였을 때, 예외를 발생시킴`() {
        testExceptions(
            input = "kkm",
            exceptionMessage = INVALID_NUM_OF_CARS_EXCEPTION,
            getValidatedInput = InputView::getValidatedNames
        )
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
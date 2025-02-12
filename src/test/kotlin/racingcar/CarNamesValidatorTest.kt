package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.validator.CarNamesValidator
import racingcar.validator.CarNamesValidator.Companion.EMPTY_INPUT_ERROR
import racingcar.validator.CarNamesValidator.Companion.INVALID_NAME_FORMAT_ERROR
import racingcar.validator.CarNamesValidator.Companion.INVALID_NAME_LENGTH_ERROR
import racingcar.validator.CarNamesValidator.Companion.NOT_UNIQUE_NAME_ERROR

class CarNamesValidatorTest {
    private lateinit var validator: CarNamesValidator

    @BeforeEach
    fun setUp() {
        validator = CarNamesValidator()
    }

    @Test
    fun `입력값이 비어있을 때 예외 테스트`() {
        Assertions.assertThatThrownBy {
            validator.validate(" ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EMPTY_INPUT_ERROR)
    }

    @ParameterizedTest
    @CsvSource(
        "###, @@@, !!!,''",
        "as1@, chan",
        "#poby",
        "d!b@",
    )
    fun `자동차 이름이 영문, 숫자 이외의 문자가 입력 되었을 때`(value: String) {
        Assertions.assertThatThrownBy {
            validator.validate(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INVALID_NAME_FORMAT_ERROR)
    }

    @Test
    fun `이름이 중복될 때 예외 테스트`() {
        Assertions.assertThatThrownBy {
            validator.validate("poby,chan,poby,hoby,cuby")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(NOT_UNIQUE_NAME_ERROR)
    }

    @Test
    fun `이름 길이가 5를 초과할 때 예외 테스트`() {
        Assertions.assertThatThrownBy {
            validator.validate("pobyyyyyyy,chan,pobyg")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INVALID_NAME_LENGTH_ERROR)
    }

    @Test
    fun `이름 정상 입력 테스트`() {
        Assertions.assertThatCode {
            validator.validate("poby,chan")
        }.doesNotThrowAnyException()
    }
}

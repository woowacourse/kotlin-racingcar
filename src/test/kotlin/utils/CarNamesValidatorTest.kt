package utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNamesValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["pobi,woni,jun"])
    fun `자동차 이름에 오류가 없으면 에러가 발생하지 않는다`(input: String) {
        assertDoesNotThrow { CarNamesValidator().validate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "pobi", "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u"])
    fun `자동차 갯수가 2대 이상 20대 이하가 아니면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { CarNamesValidator().validate(input) }
        assertThat(exception.message).contains(CarNamesValidator.ERROR_CAR_COUNT)
    }

    @ParameterizedTest
    @ValueSource(strings = ["Pobi,woni,jun", "pobi,woni ,jun", "pobi,woni, jun", "po bi,woni,jun", "pobi, "])
    fun `자동차 이름에 공백이 있거나 영문 소문자가 아니면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { CarNamesValidator().validate(input) }
        assertThat(exception.message).contains(CarNamesValidator.ERROR_NAME)
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,woniii", "pobi,,woni"])
    fun `자동차 이름이 1글자 이상 5글자 이하가 아니면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { CarNamesValidator().validate(input) }
        assertThat(exception.message).contains(CarNamesValidator.ERROR_NAME_LENGTH)
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,woni,pobi"])
    fun `자동차 이름에 중복이 있으면 에러가 발생한다`(input: String) {
        val exception = assertThrows<IllegalArgumentException> { CarNamesValidator().validate(input) }
        assertThat(exception.message).contains(CarNamesValidator.ERROR_CAR_UNIQUENESS)
    }
}

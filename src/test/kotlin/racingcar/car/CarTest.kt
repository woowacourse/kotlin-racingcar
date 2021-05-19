package racingcar.car

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class CarTest{

    @DisplayName("이름이 빈칸이면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun validateNameBlank(name : String){
        assertThatThrownBy {
            Car(name)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("이름이 5글자 초과면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = ["123456", "abcdef"])
    fun validateTooLongName(name : String){
        assertThatThrownBy {
            Car(name)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
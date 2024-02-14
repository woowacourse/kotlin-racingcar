package domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n", "    "])
    fun `자동차 이름은 공백을 허용하지 않는다`(input: String) {
        assertThatThrownBy {
            Car(input)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 공백을 허용하지 않습니다")
    }

    @ParameterizedTest
    @ValueSource(strings = ["shimji", "pangtae", "abcdefggeg"])
    fun `자동차 이름은 5자 이하여야 한다`(input: String) {
        assertThatThrownBy {
            Car(input)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 다섯글자 이하여야 합니다")
    }
}
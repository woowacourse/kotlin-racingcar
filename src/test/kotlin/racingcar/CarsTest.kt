package racingcar

import io.kotest.matchers.throwable.haveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @DisplayName("중복된 이름이 존재하는 경우 예외를 발생한다.")
    @Test
    fun nameDuplicateException() {
        assertThrows<IllegalArgumentException> {
            Cars.of(listOf("huni", "huni"))
            haveMessage("[ERROR] 중복된 이름이 존재합니다.")
        }
    }

    @DisplayName("정상적으로 cars를 생성한다.")
    @Test
    fun create() {
        var cars = Cars.of(listOf("huni", "choi", "jae"))
        assertAll(
            { assertThat(cars.cars).contains(Car("huni")) },
            { assertThat(cars.cars).contains(Car("choi")) },
            { assertThat(cars.cars).contains(Car("jae")) }
        )

    }

}

package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class CarTest {
    @Nested
    inner class `Car 객체의 이름은` {
        @ParameterizedTest(name = "이름을 {0}으로 넣으면 정상작동 한다.")
        @ValueSource(strings = ["1", "12345"])
        fun `1자 이상 5자 이하는 정상 작동한다`(input: String) {
            assertDoesNotThrow { Car(input) }
        }

        @ParameterizedTest(name = "이름을 {0}으로 넣으면 에러가 난다.")
        @ValueSource(strings = ["", "123456"])
        fun `1자 이상 5자 이하 이외에는 에러가 난다`(input: String) {
            assertThrows<IllegalArgumentException> { Car(input) }
        }
    }

    @Nested
    inner class `Car 객체 생성할 때` {
        @Test
        fun `location을 입력하지 않으면 0으로 초기화된다`() {
            val car = Car("hihi")
            assertThat(car.location).isEqualTo(0)
        }

        @Test
        fun `location을 입력하면 입력한 값으로 초기화된다`() {
            val car = Car("hihi", 1)
            assertThat(car.location).isEqualTo(1)
        }
    }

    @Nested
    inner class `Car 객체의 숫자는` {
        @ParameterizedTest(name = "숫자가 {0} 이라면 자동차는 이동하지 않는다.")
        @ValueSource(ints = [0, 1, 2, 3])
        fun `숫자가 4 이하인 경우 이동하지 않는다`(input: Int) {
            val car = Car("hihi")
            car.move(input)
            assertThat(car.location).isEqualTo(0)
        }

        @ParameterizedTest(name = "숫자가 {0} 이라면 자동차는 이동한다.")
        @ValueSource(ints = [4, 5, 6, 7, 8, 9])
        fun `숫자가 4 이상인 경우 이동한다`(input: Int) {
            val car = Car("hihi")
            car.move(input)
            assertThat(car.location).isEqualTo(1)
        }

        @ParameterizedTest(name = "숫자 {0} 입력 시 오류 발생")
        @ValueSource(ints = [-1, 10])
        fun `0~9이외 수 입력 시 오류 발생`(input: Int) {
            val car = Car("hihi")
            assertThrows<IllegalArgumentException> {
                car.move(input)
            }
        }
    }
}

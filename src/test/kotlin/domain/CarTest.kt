package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = [" ", "\t", "\r", "\n"])
    fun `자동차 이름이 공백일 경우 예외가 발생한다`(name: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                Car(name)
            }
        assertThat(exception.message).isEqualTo("잘못 입력된 자동차 이름 -> $name : 자동차 이름은 공백이 불가합니다.")
    }

    @Test
    fun `자동차 이름이 5자를 초과할 경우 예외가 발생한다`() {
        val name = "abcdef"
        val exception =
            assertThrows<IllegalArgumentException> {
                Car(name)
            }
        assertThat(exception.message).isEqualTo("잘못 입력된 자동차 이름 -> $name : 자동차 이름은 5자를 초과할 수 없습니다.")
    }

    @Test
    fun `유효한 자동차 이름이 주어진 경우 정상적으로 생성된다`() {
        val name = "abcde"
        val car = Car(name)
        assertThat(car.name).isEqualTo(name)
        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5])
    fun `무작위 값이 4 이상인 경우, 자동차는 전진한다`(num: Int) {
        val car = Car("test")
        car.move(num)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `무작위 값이 4 미만인 경우, 자동차는 전진하지 않는다`() {
        val car = Car("test")
        val num = 3
        car.move(num)
        assertThat(car.position).isEqualTo(0)
    }
}

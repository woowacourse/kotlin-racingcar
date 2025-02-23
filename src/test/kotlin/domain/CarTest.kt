package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CarTest {
    @Test
    @DisplayName("Car 객체는 내부적으로 5자를 초과하는 이름을 가질 수 없다")
    fun t1() {
        assertThrows<IllegalArgumentException> {
            Car("sdfgsadfad")
        }
    }

    @Test
    @DisplayName("Car 객체는 특수문자를 이름으로 가질 수 없다")
    fun t2() {
        assertThrows<IllegalArgumentException> {
            Car("$@#")
        }
    }

    @Test
    @DisplayName("4 이상의 값을 입력받으면 앞으로 전진한다")
    fun t3() {
        val car = Car("a")
        car.moveForward(4)
        assertThat(car.distance).isEqualTo(1)
    }

    @Test
    @DisplayName("4 이상의 값을 입력받으면 앞으로 전진한다")
    fun t3_1() {
        val car = Car("a")
        car.moveForward(4)
        car.moveForward(3)

        assertThat(car.distance).isEqualTo(1)
    }
}

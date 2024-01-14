package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @DisplayName("차량 생성 테스트")
    @Test
    fun carCreate() {
        val car = Car("Benz")

        assertThat(car).isNotNull()
    }

    @DisplayName("차 이름은 5글자를 초과 할 수 없다.")
    @Test
    fun validate_name_over() {
        assertThatThrownBy {
            Car("5글자 이상")
        }
    }

    @DisplayName("4이상일 경우 차량이 전진 할 수 있다.")
    @Test
    fun car_movingForward() {
        var car = Car("Benz")

        car.movingForward(4)

        assertThat(car.distance).isEqualTo(1)
    }

    @DisplayName("4 이하 인 경우 차량은 전진 할 수 없다.")
    @Test
    fun car_notMoving() {
        var car = Car("Benz")

        car.movingForward(3)

        assertThat(car.distance).isEqualTo(0)
    }

}
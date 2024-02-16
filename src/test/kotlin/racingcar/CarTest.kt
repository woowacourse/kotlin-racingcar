package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {
    @Test
    fun `올바른 차 전진 테스트`() {
        val car = Car(name = "pobi")
        repeat(2) {
            car.moveCar()
        }
        val expectNumberOfPosition = 2

        val actualNumberOfPosition = car.position

        assertThat(actualNumberOfPosition).isEqualTo(expectNumberOfPosition)
    }

    @Test
    fun `올바르지 않은 차 전진 테스트`() {
        val car = Car(name = "pobi")
        repeat(2) {
            car.moveCar()
        }
        val expectNumberOfPosition = 1

        val actualNumberOfPosition = car.position

        assertThat(actualNumberOfPosition).isNotEqualTo(expectNumberOfPosition)
    }
}

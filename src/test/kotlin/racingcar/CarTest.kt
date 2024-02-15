package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {

    @Test
    fun `올바른 차 전진 테스트`(){
        val car = Car(name = "pobi")
        val expectNumberOfStep = 2
        repeat(2){
            car.moveCar()
        }
        val actualNumberOfStep = car.getStep()
        assertThat(actualNumberOfStep).isEqualTo(expectNumberOfStep)
    }

    @Test
    fun `올바르지 않은 차 전진 테스트`(){
        val car = Car(name = "pobi")
        val expectNumberOfStep = 1
        repeat(2){
            car.moveCar()
        }
        val actualNumberOfStep = car.getStep()
        assertThat(actualNumberOfStep).isNotEqualTo(expectNumberOfStep)
    }
}

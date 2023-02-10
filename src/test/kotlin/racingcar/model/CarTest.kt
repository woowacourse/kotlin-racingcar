package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.entity.Car
import racingcar.entity.Name
import racingcar.entity.Position

class CarTest {
    @Test
    fun `4 이상의 값으로 forward 호출시 position이 1 증가`() {
        val car = Car(Name("test1"), Position(3))
        car.forward(5)
        assertThat(car.position.value).isEqualTo(4)
    }

    @Test
    fun `4 미만의 값으로 forward 호출시 position이 증가하지 않음`() {
        val car = Car(Name("test1"), Position(3))
        car.forward(3)
        assertThat(car.position.value).isEqualTo(3)
    }

    @Test
    fun `position 비교시 크거나 같으면 참`() {
        val car1 = Car(Name("test1"), Position(3))
        val car2 = Car(Name("test2"), Position(1))
        assertThat(car1.compareByPosition(car2)).isTrue
    }
}

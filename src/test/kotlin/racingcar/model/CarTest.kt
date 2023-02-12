package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.entity.Car
import racingcar.entity.Name

class CarTest {
    @Test
    fun `forward와 compareTo 테스트`() {
        val car1 = Car(Name("test1"))
        val car2 = Car(Name("test2"))
        car1.forward()
        assertThat(car1.compareTo(car2)).isTrue
    }
}

package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun forward() {
        val car1 = Car("test1")
        val car2 = Car("test2")
        car1.forward()
        assertThat(car1.compareTo(car2)).isTrue
    }
}

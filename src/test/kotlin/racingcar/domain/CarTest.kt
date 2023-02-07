package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {
    @Test
    fun `Car 객체 생성이 잘 되는지 확인`() {
        var car = Car("hihi")
        assertThat(car.name).isEqualTo("hihi")
        assertThat(car.location).isEqualTo(0)
    }

    @Test
    fun `Car 위치가 잘 이동되는지 확인`() {
        var car = Car("hihi")
        car.plusLocation()
        assertThat(car.location).isEqualTo(1)
    }
}

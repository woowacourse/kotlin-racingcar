package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

private const val PROCEED_FlAG_NUMBER = 4

class CarTest {
    @Test
    @DisplayName("4 이상의 숫자를 넣으면 전진해야 합니다.")
    fun proceed() {
        val car = KCar("k")
        car.proceed(PROCEED_FlAG_NUMBER)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    @DisplayName("4 미만의 숫자를 넣으면 전진을 하지 않아야 합니다.")
    fun not_proceed() {
        val car = KCar("k")
        car.proceed(PROCEED_FlAG_NUMBER - 1)
        assertThat(car.position).isEqualTo(0)
    }
}
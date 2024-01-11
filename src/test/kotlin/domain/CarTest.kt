package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @DisplayName("차량 생성 테스트")
    @Test
    fun car_create() {
        val car = Car("Benz");

        assertThat(car).isNotNull();
    }
}
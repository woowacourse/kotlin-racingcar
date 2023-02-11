package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    private var car = Car("woni")

    @BeforeEach
    fun setUp() {
        car = Car("woni")
    }

    @Test
    fun `랜덤 숫자가 4,5가 나왔을 떄 테스트`() {
        car.move(4)
        car.move(5)
        assertThat(car.position).isEqualTo(2)
    }

    @ParameterizedTest
    @CsvSource("4", "5", "6", "7", "8", "9")
    fun `랜덤 숫자가 4부터 9까지 사잇값이 나왔을 떄 이동하는지 테스트`(randomNumber: Int) {
        car.move(randomNumber)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource("1", "2", "3")
    fun `랜덤 숫자가 1부터 3까지 사잇값이 나왔을 떄 이동을 안하는지 테스트`(randomNumber: Int) {
        car.move(randomNumber)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `getName() 정상적으로 작동하는지 테스트`() {
        assertThat(car.name).isEqualTo("woni")
    }
}

package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    private var car = Car("woni")

    @BeforeEach
    fun setUp() {
        car = Car("woni")
    }

    @Test
    fun `기준값이 4이상의 값이면 자동차가 한 칸 이동한다`() {
        car.move(4)
        car.move(5)
        assertThat(car.position).isEqualTo(2)
    }

    @Test
    fun `기준값이 4미만의 값이면 자동차가 이동하지 않는다`() {
        car.move(1)
        car.move(2)
        assertThat(car.position).isEqualTo(0)
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
        assertThat(car.getName()).isEqualTo("woni")
    }

    @Test
    fun `차 이름이 5글자가 넘으면 exception 발생`() {
        assertThrows<IllegalArgumentException> {
            Car("aaaaaa")
        }
    }

    @Test
    fun `차 이름이 블랭크면 exception 발생`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }
}

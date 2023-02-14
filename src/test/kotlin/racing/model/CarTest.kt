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
        car = Car("ban",2)
        car.move(4)
        assertThat(car.position).isEqualTo(3)
    }

    @Test
    fun `기준값이 4미만의 값이면 자동차가 이동하지 않는다`() {
        car = Car("son",4)
        car.move(1)
        assertThat(car.position).isEqualTo(4)
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
    fun `차 이름은 최대 5글자이다`() {
        assertThrows<IllegalArgumentException> {
            Car("aaaaaa")
        }
    }

    @Test
    fun `자동차의 이름은 비어있을 수 없다`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }
}

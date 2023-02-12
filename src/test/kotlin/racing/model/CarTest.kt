package racing.model

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    private val car = Car("woni")

    @Test
    fun `차 이름이 5글자가 넘으면 exception 발생`() {
        assertThatIllegalArgumentException().isThrownBy { Car("aaaaaa") }.withMessageContaining("$ERROR_MESSAGE aaaaaa")
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자가 4부터 9까지 사잇값이 나왔을 떄 이동`(randomNumber: Int) {
        car.move(randomNumber)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `랜덤 숫자가 1부터 3까지 사잇값이 나왔을 떄 이동하지않음`(randomNumber: Int) {
        car.move(randomNumber)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `두번 이동 했을 때의 position은 2`(){
        car.move(PROGRESS)
        car.move(PROGRESS)
        assertThat(car.position).isEqualTo(2)
    }

    companion object{
        private const val ERROR_MESSAGE = "[Error]"
        private const val PROGRESS = 9
    }
}

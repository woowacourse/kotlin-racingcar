package racingcar.model

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class CarTest {

    @DisplayName("자동차를 생성한다")
    @Test
    internal fun `create car`() {
        assertThatCode { Car("Benz") }.doesNotThrowAnyException()
    }

    @DisplayName("move pivot 보다 condition이 작으면 정지한다")
    @Test
    internal fun `stop car when condition less than move pivot`() {
        //given
        val car = Car("Benz")

        //when
        val stoppedCar = car.move(3)

        //then
        assertThat(stoppedCar.position).isEqualTo(0)
    }

    @DisplayName("move pivot 보다 condition이 크거나 같으면 정지한다")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    internal fun `move car when condition less than move pivot`(condition: Int) {
        //given
        val car = Car("Benz")

        //when
        val movedCar = car.move(condition)

        //then
        assertThat(movedCar.position).isEqualTo(1)
    }

    @DisplayName("자동차의 이름이 5글자를 초과하면 예외를 발생한다")
    @Test
    internal fun `car name length over than max car name length`() {
        //given
        val name = "Hyundai"

        //when //then
        assertThatIllegalArgumentException()
            .isThrownBy { Car(name) }
    }
}

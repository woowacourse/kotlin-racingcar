package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @DisplayName("자동차를 생성한다")
    @Test
    internal fun `create car`() {
        assertThatCode { Car(0) }.doesNotThrowAnyException()
    }

    @DisplayName("move pivot 보다 condition이 작으면 정지한다")
    @Test
    internal fun `stop car when condition less than move pivot`() {
        //given
        val car = Car()

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
        val car = Car()

        //when
        val movedCar = car.move(condition)

        //then
        assertThat(movedCar.position).isEqualTo(1)
    }
}

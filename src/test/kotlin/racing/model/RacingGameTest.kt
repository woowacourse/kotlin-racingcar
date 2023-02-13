package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class RacingGameTest {

    @Test
    fun `잘못된 Car Name이 포함되어 있다면 예외처리`() {
        assertThatIllegalArgumentException()
            .isThrownBy { RacingGame.getCars(listOf("sixchar", "woowa")) }
            .withMessageContaining("$ERROR_MESSAGE sixchar 자동차 이름은 5글자까지 가능합니다.")
    }

    @Test
    fun `getCars()로 반환이 되는지 확인`() {
        //given
        val carNames = listOf("woni", "pobi", "jason")

        //when
        val cars = RacingGame.getCars(carNames)

        //then
        assertThat(cars.map { car: Car -> car.name })
            .isEqualTo(listOf("woni", "pobi", "jason"))
    }

    @Test
    fun `우승자가 woni 한 명일 때 승자 이름에 woni를 담아 반환한다`() {
        val cars = RacingGame.getCars(listOf("woni", "pobi", "jason"))
        cars[WONI].move(PROGRESS)
        assertThat(RacingGame.getWinnerNames(cars)).isEqualTo(listOf("woni"))
    }

    @Test
    fun `우승자가 woni와 pobi 두 명일 때 승자 이름에 담아 반환한다`() {
        val cars = RacingGame.getCars(listOf("woni", "pobi", "jason"))
        cars[WONI].move(PROGRESS)
        cars[POBI].move(PROGRESS)
        assertThat(RacingGame.getWinnerNames(cars)).isEqualTo(listOf("woni", "pobi"))
    }

    companion object {
        private const val ERROR_MESSAGE = "[Error]"
        private const val PROGRESS = 9
        private const val WONI = 0
        private const val POBI = 1
    }
}

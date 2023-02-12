package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RacingGameTest {

    @BeforeEach
    fun setUp(){
        RacingGame.removeAllCars()
        RacingGame.registerCars(listOf("woni", "pobi", "jason"))
    }

    @Test
    fun `잘못된 Car Name이 포함되어 있다면 예외처리`() {
        assertThatIllegalArgumentException().isThrownBy { RacingGame.registerCars(listOf("sixchar", "woowa")) }
    }

    @Test
    fun `getCars()로 반환이 되는지 확인`() {
        assertThat(RacingGame.cars.map { car: Car -> car.name })
            .isEqualTo(listOf(Car("woni"), Car("pobi"), Car("jason")).map { car: Car -> car.name })
    }

    @Test
    fun `우승자가 woni 한 명일 때 승자 이름에 woni를 담아 반환한다`() {
        RacingGame.cars[WONI].move(PROGRESS)
        assertThat(RacingGame.getWinnerNames()).isEqualTo(listOf("woni"))
    }

    @Test
    fun `우승자가 woni와 pobi 두 명일 때 승자 이름에 담아 반환한다`() {
        RacingGame.cars[WONI].move(PROGRESS)
        RacingGame.cars[POBI].move(PROGRESS)
        assertThat(RacingGame.getWinnerNames()).isEqualTo(listOf("woni", "pobi"))
    }

    companion object {
        private const val PROGRESS = 9
        private const val WONI = 0
        private const val POBI = 1
    }
}

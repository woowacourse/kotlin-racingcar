package domainTest

import domain.game.CarRacingGameWinner
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarRacingGameWinnerTest : BaseForTest() {
    lateinit var carRacingGameWinner: CarRacingGameWinner

    @BeforeEach
    private fun setUp() {
        carRacingGameWinner = CarRacingGameWinner()
    }

    @Test
    fun `우승자가 한명인 경우`() {
        movingCars.first().move()
        stopCars.first().move()

        assertThat(
            carRacingGameWinner.judgeWinners(
                listOf(
                    movingCars.first(),
                    stopCars.first()
                )
            )
        ).isEqualTo(listOf(movingCars.first().name))
    }

    @Test
    fun `우승자가 여러명인 경우`() {
        movingCars.forEach { movingCar ->
            movingCar.move()
        }

        assertThat(
            carRacingGameWinner.judgeWinners(movingCars)
        ).isEqualTo(
            movingCars.map { movingCar ->
                movingCar.name
            }
        )
    }
}

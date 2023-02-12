package domainTest.gameTest

import domain.game.CarRacingGameReferee
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RefereeTest : GameBaseTest() {
    lateinit var carRacingGameReferee: CarRacingGameReferee

    @BeforeEach
    private fun setUp() {
        carRacingGameReferee = CarRacingGameReferee()
    }

    @Test
    fun `우승자가 한명인 경우`() {
        movingCars.first().move()
        stopCars.first().move()

        assertThat(
            carRacingGameReferee.judgeWinners(
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
            carRacingGameReferee.judgeWinners(movingCars)
        ).isEqualTo(
            movingCars.map { movingCar ->
                movingCar.name
            }
        )
    }
}

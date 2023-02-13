package domain

import model.Car
import model.CarPath
import model.PathState
import model.generator.NumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingGameTest {

    private val carRacingGame = CarRacingGame(object : NumberGenerator {
        override fun generate(): Int {
            return MOVE_NUMBER
        }
    })

    @Test
    fun startDrivingTest() {
        val cars = listOf(Car(NAME1), Car(NAME2))

        val carsPath = carRacingGame.startDriving(cars, NUMBER_OF_TRY)
        val result = listOf(CarPath(NAME1, MOVE_PATH), CarPath(NAME2, MOVE_PATH))

        assertThat(carsPath).isEqualTo(result)
    }

    companion object {
        const val MOVE_NUMBER = 5
        const val NAME1 = "핑구"
        const val NAME2 = "우기"
        const val NUMBER_OF_TRY = 3
        val MOVE_PATH = listOf(PathState.MOVE, PathState.MOVE, PathState.MOVE)
    }
}

package domain

import constant.RacingGameOutputConstant.ROUND_RESULT_FORMAT
import java.util.Random

class RoundResult(
    private val cars: List<Car>,
) {
    fun runEachCar() {
        for (car in cars) {
            car.moveCar(Random())
        }
    }

    fun getRoundResult(): List<String> {
        return cars.map { ROUND_RESULT_FORMAT.format(it.name, "-".repeat(it.currentPosition)) }
    }
}

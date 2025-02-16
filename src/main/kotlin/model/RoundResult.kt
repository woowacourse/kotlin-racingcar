package model

import constant.MessageConstant.ROUND_RESULT_FORMAT
import java.util.Random

class RoundResult(
    private val cars: List<Car>,
) {
    fun runCarAndGetRoundResult(): List<String> {
        runEachCar()
        return getRoundResult()
    }

    private fun runEachCar() {
        for (car in cars) {
            car.moveCar(Random())
        }
    }

    private fun getRoundResult(): List<String> {
        return cars.map { ROUND_RESULT_FORMAT.format(it.name, "-".repeat(it.currentPosition)) }
    }
}

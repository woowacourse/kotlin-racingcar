package racingcar.controller

import racingcar.domain.Cars

class RacingController(
    private val inputController: InputController = InputController(),
    private val outputController: OutputController = OutputController(),
) {

    fun runRacing() {
        val cars = inputController.readCars()
        val roundCount = inputController.readRoundCount()

        runRounds(roundCount, cars)

        val winners = cars.getWinners()
        outputController.printWinners(winners.cars)
    }

    private fun runRounds(roundCount: Int, cars: Cars) {
        outputController.printRunResult()
        repeat(roundCount) {
            runRound(cars)
        }
    }

    private fun runRound(cars: Cars) {
        cars.moveCarsRandomly()
        outputController.printRoundResult(cars.cars)
    }
}

package racingcar.controller

import racingcar.model.Car
import racingcar.service.RacingService

class RacingController(
    private val inputController: InputController = InputController(),
    private val viewController: ViewController = ViewController(),
    private val racingService: RacingService = RacingService(),
) {
    fun runRacing() {
        val cars = createCars(inputController.readCarNames())
        val roundCount = inputController.readRoundCount()

        runRounds(roundCount, cars)

        val winners = getWinners(cars)
        viewController.printWinners(winners)
    }

    private fun runRounds(roundCount: Int, cars: List<Car>) {
        viewController.printRunResult()
        repeat(roundCount) {
            runRound(cars)
        }
    }

    private fun runRound(cars: List<Car>) {
        moveCarsRandomly(cars)
        viewController.printRoundResult(cars)
    }

    private fun moveCarsRandomly(cars: List<Car>) {
        cars.forEach { car ->
            racingService.moveRandomly(car)
        }
    }

    private fun createCars(carNames: List<String>) =
        carNames.map { carName ->
            racingService.createCar(carName)
        }

    private fun getWinners(cars: List<Car>): List<Car> = racingService.getWinners(cars)
}

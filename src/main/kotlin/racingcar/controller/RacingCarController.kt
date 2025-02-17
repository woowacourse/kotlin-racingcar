package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Racecourse
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    val outputView = OutputView()
    val inputView = InputView()

    fun start() {
        val cars = createCarName()
        val round = createRound()
        createResult(cars, round)
    }

    private fun createCarName(): List<Car> {
        outputView.printCarName()
        val cars: List<Car>? = inputView.readCars()
        if (cars == null) {
            outputView.printReCarName()
            return createCarName()
        }
        return cars
    }

    private fun createRound(): Int {
        outputView.printRound()
        val round: Int? = inputView.readRound()
        if (round == null) {
            outputView.printReRound()
            return createRound()
        }
        return round
    }

    private fun createResult(
        cars: List<Car>,
        round: Int,
    ) {
        outputView.printResult()
        val racecourse = Racecourse(cars, round)
        racecourse.startRace()
    }
}

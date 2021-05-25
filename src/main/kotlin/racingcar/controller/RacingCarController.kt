package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RacingCarGame
import racingcar.model.RandomMoveStrategy
import racingcar.view.inputCarNames
import racingcar.view.inputTryNumber
import racingcar.view.printResults

class RacingCarController {

    fun run() {
        val cars = createCars(inputCarNames())
        val tryNumber = inputTryNumber()
        val racingCarGame = RacingCarGame(cars, tryNumber)
        val racingResult = racingCarGame.race(RandomMoveStrategy())
        printResults(racingResult)
    }

    private fun createCars(carNames: List<String>): Cars {
        return Cars(carNames.map { Car(it) })
    }
}

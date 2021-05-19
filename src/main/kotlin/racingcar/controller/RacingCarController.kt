package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RacingCarGame
import racingcar.model.RandomMoveStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {

    fun run() {
        val cars = createCars(InputView.inputCarNames())
        val tryNumber = InputView.inputTryNumber()
        val racingCarGame = RacingCarGame(cars, tryNumber)
        val racingResult = racingCarGame.race(RandomMoveStrategy())
        OutputView.printResults(racingResult)

        val winners = racingCarGame.findWinners()
        OutputView.printWinners(winners)
    }

    private fun createCars(carNames: List<String>): Cars {
        val cars = arrayListOf<Car>()
        for (carName in carNames) {
            cars.add(Car(carName))
        }
        return Cars(cars)
    }
}

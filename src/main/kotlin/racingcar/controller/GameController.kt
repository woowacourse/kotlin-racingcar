package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {
    fun playGame() {
        val cars = initCars()
        val laps = InputView.inputLaps()

        val racingGame = RacingGame(cars, laps)
        racingGame.race()

        OutputView.printHistory(racingGame.history())
        OutputView.printWinners(racingGame.winner())
    }

    private fun initCars(): Cars {
        val carNames: List<Car> = InputView.inputCarNames().map { Car(it) }
        return Cars(carNames)
    }
}
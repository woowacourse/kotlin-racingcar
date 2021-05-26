package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.input.InputView
import racingcar.input.OutputView

class GameController {
    fun playGame() {
        val carNames = InputView.inputCarNames().map { Car(it) }
        val laps = InputView.inputLaps()

        val racingGame = RacingGame(Cars(carNames), laps)

        OutputView.printResult()
        while (!racingGame.isEnd()) {
            racingGame.race()
            OutputView.printCars(racingGame.cars)
        }

        OutputView.printWinners(racingGame.winner())
    }
}
package racing.controller

import racing.model.Car
import racing.model.RacingGame
import racing.view.InputView
import racing.view.OutputView

class RacingCarController {

    fun initRace() {
        val cars = mutableListOf<Car>()
        InputView.inputCarNames().map {
            cars.add(Car(it))
        }
        val maxMoveCount = InputView.inputCount()
        val racingGame = RacingGame()
        racingGame.initRacing(cars)
        startRacing(maxMoveCount, racingGame)
    }

    private fun startRacing(maxMoveCount: Int, racingGame: RacingGame) {
        val result = racingGame.race(maxMoveCount)
        val carNames = racingGame.getCars().map { it.getName() }
        OutputView.printGameResult(carNames, result)
        OutputView.printWinners(racingGame.getWinners())
    }
}

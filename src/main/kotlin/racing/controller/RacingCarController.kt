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
        println("실행 결과")
        val carCount = racingGame.getCars().size
        repeat(maxMoveCount) {
            racingGame.moveCars(racingGame.createRandomNumbers(carCount))
            OutputView.printCurrentPosition(racingGame.getCars())
        }
        OutputView.printWinners(racingGame.getWinners())
    }
}
